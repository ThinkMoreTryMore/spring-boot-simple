<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/layout.css" />
<link rel="stylesheet" href="css/singer.css" />

<div class="main">
<!-- 歌手列表 -->
<div id="mod_singerlist">
    <!-- 头像 -->
    <div class="mod_singer_list">
<ul class="clearfix singer_list_list js_avtar_list">
    <#list albumPage.list as album>
        <li class="singer_list_item">
            <div class="singer_list_item_box">
                <a href="Singer?singer.id=${album.id}"
                   class="singer_list_cover"> <img src="img/lcy.jpg"
                                                   alt="${album.name }" class="singer_list_pic">
                </a>
                <h3 class="singer_list_title">
                    <a href="#" class="js_singer" title="${album.name }">${album.name }</a>
                </h3>
            </div>
        </li>
    </#list>
</ul>

    </div>
</div>

</div>
