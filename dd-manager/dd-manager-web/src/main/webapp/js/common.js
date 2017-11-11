
var ddshop = {

    registerMenuEvent:function(){
        var _this = this;
        var $tree = $('#menu .easyui-tree');
        $tree.tree({
            onClick:function(node){
                var href = node.attributes.href;//item-add
                var text = node.text;
                // $('#tab').tabs('add',{
                //     title: text,
                //     href: href,
                //     closable:true
                // });
                _this.addTabs(text,href);
            }
        });
    },
    addTabs:function(text,href){
        if($('#tab').tabs('exists',text)){
            $('#tab').tabs('select',text)
        }else{
            $('#tab').tabs('add',{
                title: text,
                href: href,
                closable:true
            });
        }


    }

};



