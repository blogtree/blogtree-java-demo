<#include "../layout.ftl">

<@layout>
    <style>
        .layui-card-body button {
            margin: 6px auto;
        }
    </style>

    <div class="layui-card">
        <div class="layui-card-header">jQuery Post 对象</div>
        <div class="layui-card-body">
            <button class="layui-btn layui-btn-primary layui-border-blue" onclick="postBean()">Post Bean</button>
        </div>
    </div>

    <div class="layui-card">
        <div class="layui-card-header">jQuery Post 数组或列表</div>
        <div class="layui-card-body">
            <button class="layui-btn layui-btn-primary layui-border-blue" onclick="postIntegerList()">Post Integer List</button>
            <button class="layui-btn layui-btn-primary layui-border-blue" onclick="postBeanList()">Post Bean List</button>
            <button class="layui-btn layui-btn-primary layui-border-blue" onclick="postBeanListWithChildBean()">
                Post Bean List With Child Bean
            </button>
            <button class="layui-btn layui-btn-primary layui-border-blue" onclick="postBeanListWithChildStringList()">
                Post Bean List With Child String List
            </button>
            <button class="layui-btn layui-btn-primary layui-border-blue" onclick="postBeanListWithChildBeanList()">
                Post Bean List With Child Bean List
            </button>
        </div>
    </div>



    <script>
        function postBean() {
            var bean = {
                id: 1, name: "Alan",
                tags: ["a", "b"],
                child: {key: "key1", value: "value1"},
                children: [
                    {key: "key1-1", value: "value1-1"},
                    {key: "key1-2", value: "value1-2"}
                ]
            };
            $.ajax({
                url: "/jQuery/postBean",
                type: "post",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(bean),
                success: function (data) {
                    alterUtil.success("Post成功")
                },
                complete: function () {

                }
            })
        }

        function postIntegerList() {
            var list = [1, 2, 3, 4, 5, 6];
            $.ajax({
                url: "/jQuery/postIntegerList",
                type: "post",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(list),
                success: function (data) {
                    alterUtil.success("Post成功")
                },
                complete: function () {

                }
            })
        }

        function postBeanListCommon(data) {
            $.ajax({
                url: "/jQuery/postBeanList",
                type: "post",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (data) {
                    alterUtil.success("Post成功")
                }
            })
        }

        function postBeanList() {
            var list = [
                {id: 1, name: "Alan"},
                {id: 2, name: "Lyon"}
            ];
            postBeanListCommon(list);
        }

        function postBeanListWithChildBean() {
            var list = [
                {
                    id: 1, name: "Alan",
                    child: {key: "key1", value: "value1"}
                },
                {
                    id: 2, name: "Lyon",
                    child: {key: "key2", value: "value2"}
                }
            ];
            postBeanListCommon(list);
        }

        function postBeanListWithChildStringList() {
            var list = [
                {
                    id: 1, name: "Alan",
                    tags: ["a", "b"]
                },
                {
                    id: 2, name: "Lyon",
                    tags: ["x", "y"]
                }
            ];
            postBeanListCommon(list);
        }

        function postBeanListWithChildBeanList() {
            var list = [
                {
                    id: 1, name: "Alan",
                    children: [
                        {key: "key1-1", value: "value1-1"},
                        {key: "key1-2", value: "value1-2"}
                    ]
                },
                {
                    id: 2, name: "Lyon",
                    children: [
                        {key: "key2-1", value: "value2-1"},
                    ]
                }
            ];
            postBeanListCommon(list);
        }

    </script>
</@layout>