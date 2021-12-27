<#macro layout>
    <!DOCTYPE html>
    <html lang="zh">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no shrink-to-fit=no">

        <title>${(title??)?string(title,'Spring Boot Demo | BlogTree')}</title>

        <link rel="stylesheet" href="/npm/layui@2.6.8/css/layui.css">

        <script src="/npm/jquery@3.6.0/jquery.min.js"></script>
        <script src="/npm/layui@2.6.8/layui.js"></script>

        <style>
            body {
                background-color: #e2e2e2;
                padding: 20px;
            }

            .w-article {
                display: flex;
                flex-flow: row nowrap;
            }

            .w-article-left {
                margin-right: 16px;
            }

            body .layui-card {
                min-width: 600px;
            }


        </style>
    </head>
    <body>
    <header>

    </header>

    <article class="w-article">
        <div class="w-article-left">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="/">首页</a></li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">前端调后端</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/jQuery">jQuery 调用 Spring MVC</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
        <div class="w-article-right">
            <#nested>
        </div>
    </article>

    <footer>

    </footer>


    <script>
        var alterUtil = {
            success: function (msg) {
                layer.alert(msg, {icon: 1});
            }, warn: function (msg) {
                layer.alert(msg, {icon: 0});
            }, error: function (msg) {
                layer.alert(msg, {icon: 2});
            }
        }
    </script>

    </body>
    </html>
</#macro>