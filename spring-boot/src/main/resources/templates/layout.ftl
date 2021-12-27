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
        </style>
    </head>
    <body>
    <header>

    </header>

    <article>
        <#nested>
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