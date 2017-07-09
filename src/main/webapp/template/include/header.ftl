<div class="n-head">
    <div class="g-doc f-cb">


        <#if (Session.get('user'))??>
            <#assign user=Session.get("user")/>
            usertype ${(user.usertype)!}<br>
            username ${(user.userName)!}<br>
        </#if>
        <div class="user">
        <#if user.id??>
            <#if user.usertype??>
                <#if user.usertype==1>卖家
                <#else>买家
                </#if>
                你好，
                <span class="name">${(user.userName)!"默认值"}</span>！
                <a href="/logout">[退出]</a>
            </#if>
        <#else>
            请<a href="/login">[登录]</a>
        </#if>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>

        <#if user??>
            <#if user.usertype??>
                <#if user.usertype==0>
                    <li><a href="/account">账务</a></li>
                    <li><a href="/settleAccount">购物车</a></li>
                <#else >
                    <li><a href="/public">发布</a></li>
                </#if>
            </#if>
        </#if>
        </ul>
    </div>
</div>