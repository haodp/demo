<script type="text/javascript">
	$(function() {
		var jsontree = "<%=session.getAttribute("menuInfo")%>";
		$('#treeview').treeview({data: getTree()});
	});
</script>
<div id="treeview" />