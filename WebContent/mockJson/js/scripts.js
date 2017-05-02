var apps =  angular.module('myApp', []);

apps.controller('validateCtrl', function($scope,$http, $window) {
	$scope.go = function() {
		if($scope.user == 'user' && $scope.password == 'password')
			$window.location.href = '/SPIDashboardUI/search.html';
		else
			alert("Invalid User");
	};
});

var app = angular.module('angularTable', ['angularUtils.directives.dirPagination','wt.responsive']);


app.controller('listdata',function($scope, $http){
	$scope.go = function() {
		var dataS = 'Volunteer';

		if($scope.Name != null) dataS = dataS+"$"+$scope.Name;
		else dataS = dataS+'$null';
		if($scope.Mobile_Number != null) dataS = dataS+"$"+$scope.Mobile_Number;
		else dataS = dataS+'$null';
		if($scope.District != null) dataS = dataS+"$"+($scope.District).trim();
		else dataS = dataS+'$null';

		$scope.users = [];
		 $http({
		        method: 'POST',
		        url: 'http://sattapanchayat.com/SPIService/rest/UserService/memberPost',
		        data: dataS,
				 headers: {
		             'Content-Type': 'application/json; charset=utf-8'
				 }
		    }).success(function (data, status, headers, config) {
		    	  $scope.users = data;
		    }).error(function (data, status, headers, config) {
		        // handle error things
		    }
		    )};

		    $scope.download = function() {
		            $http.get('http://sattapanchayat.com/SPIService/rest/UserService/getFile',$scope.data,{responseType:'arraybuffer'});
		    	/*
		    	var dataS = 'Volunteer';

				if($scope.Name != null) dataS = dataS+"$"+$scope.Name;
				else dataS = dataS+'$null';
				if($scope.Mobile_Number != null) dataS = dataS+"$"+$scope.Mobile_Number;
				else dataS = dataS+'$null';
				if($scope.District != null) dataS = dataS+"$"+($scope.District).trim();
				else dataS = dataS+'$null';
				//?ts='+dataS
				 $http({
				        method: 'GET',
				        url: 'http://localhost:8888/SPIService/rest/UserService/getFile'
				    }).success(function (data, status, headers, config) {

				    }).error(function (data, status, headers, config) {

				    }
				    )*/};

	$scope.sort = function(keyname){
		$scope.sortKey = keyname;   //set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; //if true make it false and vice versa
	};

});
