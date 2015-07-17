<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<script type="text/javascript">
function selectPagesize(field){
	window.location = document.getElementById("firstPage").href + "&pagesize="+field.value;
}
</script>
<pg:pager url="${param.url}" items="${pv.total}" maxPageItems="${pagesize}" maxIndexPages="10" export="currentPageNumber=pageNumber">

	<span class="totalPage">共有<span class="f_b redColor"> ${pv.total } </span> 条记录， 当前第 <span
		class="f_b redColor">${currentPageNumber }</span> 页 <pg:last> 共<span
				class="f_b redColor"> ${pageNumber } </span>页</pg:last> </span>

	<div class="page ff">
		<c:forEach items="${param.params}" var="p">
			<pg:param name="${p}" />
		</c:forEach>
		<pg:first>
			<ul class="pagination pagination-group border-sub pagination-small">
				<li>
					<a id="firstPage" href="${pageUrl}">首页</a>
				</li>
			</ul>
		</pg:first>
		<pg:prev>
			<ul class="pagination pagination-group border-sub pagination-small">
				<li>
					<a href="${pageUrl}">前页</a>
				</li>
			</ul>
		</pg:prev>
		<pg:pages>
			<ul class="pagination pagination-group border-sub pagination-small">
				<c:choose>
					<c:when test="${currentPageNumber eq pageNumber}">
						<li>
							<a href="javascript:void(0);" class="active">${pageNumber}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="${pageUrl }">${pageNumber}</a>
						</li>

					</c:otherwise>
				</c:choose>
			</ul>
		</pg:pages>
		<pg:next>
			<ul class="pagination pagination-group border-sub pagination-small">
				<li>
					<a href="${pageUrl}">下页</a>
				</li>
			</ul>
		</pg:next>
		<pg:last>
			<ul class="pagination pagination-group border-sub pagination-small">
				<li>
					<a href="${pageUrl}">尾页</a>
				</li>
			</ul>
		</pg:last>

		<select name="pagesize" onchange="selectPagesize(this)" class="input border-sub" style="width: 50px;height:30px; display: inline;line-height: 10px;">
			<c:forEach begin="10" end="50" step="10" var="i">
				<option value="${i }" <c:if test="${i eq pagesize }">selected</c:if>>
					${i }
				</option>
			</c:forEach>
		</select>
	</div>
</pg:pager>

