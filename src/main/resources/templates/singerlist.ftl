<ul class="clearfix singer_list_list js_avtar_list">
    <#list singerPage.list as singer>
        <li class="singer_list_item">
            <div class="singer_list_item_box">
                <a href="Singer?singer.id=${singer.id}"
                   class="singer_list_cover"> <img src="img/lcy.jpg"
                                                   alt="${singer.name }" class="singer_list_pic">
                </a>
                <h3 class="singer_list_title">
                    <a href="#" class="js_singer" title="${singer.name }">${singer.name }</a>
                </h3>
            </div>
        </li>
    </#list>
</ul>


