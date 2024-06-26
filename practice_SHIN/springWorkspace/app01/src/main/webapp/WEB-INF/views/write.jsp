<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

</head>
<body>
	<form id="entityForm">
        <input type="text" id="title" name="title">
        <textarea id="content" name="content"></textarea>
        <!-- Other fields as needed -->
        <button type="submit">Save</button>
    </form>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#entityForm').submit(function(event) {
                event.preventDefault();
                var formData = $(this).serialize();
                $.ajax({
                    type: 'POST',
                    url: '/entities/save',
                    data: formData,
                    success: function(response) {
                        alert('Saved successfully');
                    },
                    error: function(xhr, status, error) {
                        alert('Error saving data');
                    }
                });
            });
        });
    </script>

</body>
</html>