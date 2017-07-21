<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
<div class="g-doc">
<#if !product??>
	<div class="n-result">
		<h3>内容不存在！</h3>
	</div>
<#else>
	<div class="n-show f-cb" id="showContent">
		<div class="img"><img src="${product.image}" alt="" ></div>
		<div class="cnt">
			<h2>${product.title}</h2>
			<p class="summary">${product.summary}</p>
			<div class="price">
				<span class="v-unit">¥</span><span class="v-value">${product.price}</span>
			</div>
        <#--<#if user?? && product.sellerId != user.id>--><#-- 内容购买 不应该有数量 -->
        <#--<div class="num">-->
        <#--购买数量：-->
        <#--<span id="plusNum" class="lessNum"><a>-</a></span>-->
        <#--<span class="totalNum" id="allNum">${product.buyNum}</span>-->
        <#--<span id="addNum" class="moreNum"><a>+</a></span>-->
        <#--</div>-->
        <#--</#if >-->
			<div class="oprt f-cb">
                <#if user?? && user.userType==0>
                    <#if product.isBuy>
						<span class="u-btn u-btn-primary z-dis">已购买</span>
						<span class="buyprice">当时购买价格：¥${product.buyPrice}</span>
                    <#else>
						<button class="u-btn u-btn-primary" id="add" data-id="${product.id}" data-title="${product.title}" data-price="${product.price}">
							加入购物车</button>
                    </#if>
                </#if>
                <#if user?? && user.userType==1>
					<a href="/edit?id=${product.id}" class="u-btn u-btn-primary">编 辑</a>
                </#if>
			</div>
		</div>
	</div>
    <#if user?? && user.userType==0 && product.isBuy>
        <div class="m-tab m-tab-fw m-tab-simple f-cb">
            <h2>详细信息</h2>
        </div>
        <div class="n-detail">${product.detail}</div>
    <#elseif user?? && user.userType==1>
		<div class="m-tab m-tab-fw m-tab-simple f-cb">
			<h2>详细信息</h2>
		</div>
		<div class="n-detail">${product.detail}</div>
    <#elseif user?? >
	    <div class="m-tab m-tab-fw m-tab-simple f-cb">
		    <h2>内容预览（更多内容购买后可查看）</h2>
	    </div>
	    <p class="summary">${product.summary}</p>
    <#else>
	    <div class="m-tab m-tab-fw m-tab-simple f-cb">
		    <h2>内容预览（更多内容登陆购买后可查看）</h2>
	    </div>
	    <p class="summary">${product.summary}</p>
    </#if>
</#if>
</div>
    <#include "./include/footer.ftl">
<script type="text/javascript" src="/static/js/global.js"></script>
<script type="text/javascript" src="/static/js/pageShow.js"></script>
</body>
</html>