define('index', [], function() {
	var layout;
	var tabs;
	var menu;
	var modules = {};
	var index = {
		init: function() {
			var the = this;
			layout = $('body').layout({
				fit: true
			});
			menu = $('#menu').tree({
				lines: true,
				onClick: function(node) {
					if (node.attributes && node.attributes.leaf) {
						var exists = tabs.tabs('exists', node.text);
						if (exists) {
							tabs.tabs('select', node.text);
							return;
						}
						if (node.attributes.url)
							the.requireModule(node.attributes.code, node.text, node.attributes.url);
					}
				}
			});
			tabs = $('#index-tab').tabs({
				fit: true,
				border: false,
				onBeforeClose: function(title, index) {
					var module = modules[title];
					if (module && module.destroy) {
						module.destroy.call(module);
					}
				}
			});
		},
		requireModule: function(code, title, url) {
			var the = this;
			require(['page/' + code], function(Module) {
				modules[title] = Module;
				the.addTab({
					title: title,
					href: url
				}, function() {
					Module.init();
				});
			});
		},
		addTab: function(panel, callback) {
			var defaultOption = {
				fit: true,
				closable: true,
				onLoad: function() {
					callback.call(this);
				}
			};
			panel = $.extend(defaultOption, panel);
			tabs.tabs('add', panel);
		}
	}
	return index;
});
