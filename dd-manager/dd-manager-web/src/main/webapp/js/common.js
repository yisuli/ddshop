
var ddshop = {

    registerMenuEvent:function(){
        var $tree = $('#menu .easyui-tree');
        $tree.tree({
            onClick:function(node){
                var href = node.attributes.href;//item-add
                var text = node.text;
                $('#tab').tabs('add',{
                    title: text,
                    href: href,
                    closable:true
                });
            }
        });
    }

};



