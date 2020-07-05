angular.module('todolist', []).controller('mainController', function ($scope, $http) {
    $scope.formData = {};
    $scope.modalIndex=null;
    $scope.newContent="";
    $scope.user="you";
    
    // when landing on the page, get all tasks and show them
    $http.get('/getTaskSet').then(function(res) {
            $scope.tasks = res.data;
            $http.get('/getUser').then(function(res){
            	$scope.user=res.data;
            });
        });
       
    $scope.createTodo=function(){
    	$http.post('/addTask',$scope.formData.name).then(function(res) {
            $scope.tasks = res.data;
            $scope.formData={};
        });   	
    };
    $scope.deleteTodo=function(id){
    	$http.post('/deleteTask',id).then(function(res) {
            $scope.tasks = res.data;
            
        });
    };
    $scope.updateDone=function(task){
    	
    	$http.post('/updateDone',task).then(function(res) {
            $scope.tasks = res.data;
            
        });
    };
    $scope.openModal=function(index){
    	$scope.modalIndex=index;
    	setTimeout(function (){
            document.getElementById('editInput').focus();
        }, 500);
    };
    $scope.closeModal=function(content){
    	$scope.newContent=content;
    };
	$scope.updateTodo=function(id){
	    var task={
	    		id:id,
	    		content:$scope.newContent
	    }	
	    $http.post('/updateTask',task).then(function(res) {
	        $scope.tasks = res.data;
	        $('#exampleModal').modal('hide');
	        $scope.newContent="";
	            
	    });
	};
                         
});