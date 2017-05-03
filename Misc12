Logic that deals with storing or retrieving data is part of the model. Logic that deals with formatting the data to display to the user is part of the view. The controller sits between the model and the view and connects them. The controller responds to user interaction, updating the data in the model and providing the view with the data that it requires.


<script src="angular.js"></script>
    <script>
        var model = {
            user: "Adam",
            items: [{ action: "Buy Flowers", done: false },
                        { action: "Get Shoes", done: false },
                        { action: "Collect Tickets", done: true },
                        { action: "Call Joe", done: false }]
        };
        var todoApp = angular.module("todoApp", []);
        todoApp.controller("ToDoCtrl", function ($scope) {
            $scope.todo = model;
        });
    </script>
</head>
<body ng-controller="ToDoCtrl">
    <div class="page-header">
        <h1>To Do List</h1>
    </div>


One of the main purposes of the controller is to provide views with the data they require. You won’t always want views to have access to the complete model, so you use the controller to explicitly select those portions of the data that are going to be available, known as the scope.
The argument to my controller function is called $scope—that is to say, the $sign followed



Inserting Model Values
AngularJS uses double-brace characters ({{ and }}) to denote a data binding expression. The content of the expression is evaluated as JavaScript, limited to the data and functions assigned to the scope by the controller. I


You should use expressions only to perform simple operations to prepare data values for display. Don’t use data bindings to perform complex logic or to manipulate the model; that’s the job of the controller. You will often encounter logic that is hard to classify as being suitable for the view or the controller, and it can be difficult to work out what to do. My advice is to not worry about it. Make a best guess in order to preserve development momentum and move the logic later if need be.


Using Directives
Expressions are also used with directives, which tell AngularJS how you want content to be processed. In the listing, I used the ng-repeat attribute, which applies a directive that tells AngularJS to generate the element it is applied to and its contents for each object in a collection, as follows:
...
<tr ng-repeat="item in todo.items">
    <td>{{item.action}}</td><td>{{item.done}}</td>
</tr>



<tr ng-repeat="item in todo.items">
    <td>{{item.action}}</td>
    <td><input type="checkbox" ng-model="item.done" /></td>
    <td>{{item.done}}</td>
</tr>
...
I have added a new td element to contain a check box input element. The important addition is the ng-modelattribute, which tells AngularJS to create a two-way binding between the value of the input element and the done property of the corresponding data object (the one that the ng-repeatdirective assigned to item when generating the elements).


Creating and Using Controller Behaviors
Controllers define behaviors on the scope. Behaviors are functions that operate on the data in the model to implement the business logic in the application. The behaviors defined by a controller support a view to display data to the user and to update the model based on user interactions.
To demonstrate a simple behavior, I am going to change the label displayed to the right of the header in todo.html so that it displays only the number of incomplete to-do items. You can see the changes required to do this in Listing 2-7. (I also removed the column that contains the trueand false values, which I required only to demonstrate that data bindings reflected changes in the data model.)
Listing 2-7. Defining and Using a Controller Behavior in the todo.html File
<!DOCTYPE html>
<html ng-app="todoApp">
<head>
    <title>TO DO List</title>
    <link href="bootstrap.css" rel="stylesheet" />
    <link href="bootstrap-theme.css" rel="stylesheet" />
    <script src="angular.js"></script>
    <script>
        var model = {
            user: "Adam",
            items: [{ action: "Buy Flowers", done: false },
                        { action: "Get Shoes", done: false },
                        { action: "Collect Tickets", done: true },
                        { action: "Call Joe", done: false }]
        };
        var todoApp = angular.module("todoApp", []);
        todoApp.controller("ToDoCtrl", function ($scope) {
            $scope.todo = model;
            $scope.incompleteCount = function () {
                var count = 0;
                angular.forEach($scope.todo.items, function (item) {
                    if (!item.done) { count++ }
                });
                return count;
            }
        });
    </script>
</head>
<body ng-controller="ToDoCtrl">
    <div class="page-header">
        <h1>
            {{todo.user}}'s To Do List
            <span class="label label-default" ng-hide="incompleteCount() == 0">
                {{incompleteCount()}}
            </span>
        </h1>
    </div>
    <div class="panel">
        <div class="input-group">
            <input class="form-control" />
            <span class="input-group-btn">
                <button class="btn btn-default">Add</button>
            </span>
        </div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Done</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="item in todo.items">
                    <td>{{item.action}}</td>
                    <td><input type="checkbox" ng-model="item.done" /></td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
Behaviors are defined by adding functions to the $scope object that is passed to the controller function. In the listing, I have defined a function that returns the number of incomplete items, which I determine by enumerating the objects in the $scope.todo.itemsarray and counting the ones whose doneproperty is false.


I also used the behavior in conjunction with a directive, like this:
...
<span class="label default" ng-hide="incompleteCount() == 0">
    {{incompleteCount()}}
</span>
...
The ng-hidedirective will hide the element it is applied to—and its content elements—if the expression that is assigned as the attribute value evaluates to true. In this case, I call the incompleteCountbehavior and check to see whether the number of incomplete items is zero; if it is, then the label that displays the number of items on the list is hidden from the user.


Building on Behaviors in the todo.html File
<!DOCTYPE html>
<html ng-app="todoApp">
<head>
    <title>TO DO List</title>
    <link href="bootstrap.css" rel="stylesheet" />
    <link href="bootstrap-theme.css" rel="stylesheet" />
    <script src="angular.js"></script>
    <script>
        var model = {
            user: "Adam",
            items: [{ action: "Buy Flowers", done: false },
                        { action: "Get Shoes", done: false },
                        { action: "Collect Tickets", done: true },
                        { action: "Call Joe", done: false }]
        };
        var todoApp = angular.module("todoApp", []);
        todoApp.controller("ToDoCtrl", function ($scope) {
            $scope.todo = model;
            $scope.incompleteCount = function () {
                var count = 0;
                angular.forEach($scope.todo.items, function (item) {
                    if (!item.done) { count++ }
                });
                return count;
            }
            $scope.warningLevel = function () {
                return $scope.incompleteCount() < 3 ? "label-success" : "label-warning";
            }
        });
    </script>
</head>
<body ng-controller="ToDoCtrl">
    <div class="page-header">
        <h1>
            {{todo.user}}'s To Do List
            <span class="label label-default" ng-class="warningLevel()"
                  ng-hide="incompleteCount() == 0">
                {{incompleteCount()}}
            </span>
        </h1>
    </div>
    <!--...elements omitted for brevity...-->
</body>
</html>
I have defined a new behavior called warningLevel, which returns the name of a Bootstrap CSS class based on the number of incomplete to-do items, which is obtained by calling the incompleteCountbehavior. This approach reduces the need to duplicate logic in the controller and, as you’ll see in Chapter 25, can help simplify the process of unit testing.
I have applied the warningLevelbehavior using the ng-class directive, as follows:
...
<span class="label" ng-class="warningLevel()"ng-hide="incompleteCount() == 0">





Responding to User Input in the todo.html File
<!DOCTYPE html>
<html ng-app="todoApp">
<head>
    <title>TO DO List</title>
    <link href="bootstrap.css" rel="stylesheet" />
    <link href="bootstrap-theme.css" rel="stylesheet" />
    <script src="angular.js"></script>
    <script>
        var model = {
            user: "Adam",
            items: [{ action: "Buy Flowers", done: false },
                        { action: "Get Shoes", done: false },
                        { action: "Collect Tickets", done: true },
                        { action: "Call Joe", done: false }]
        };
        var todoApp = angular.module("todoApp", []);
        todoApp.controller("ToDoCtrl", function ($scope) {
            $scope.todo = model;
            $scope.incompleteCount = function () {
                var count = 0;
                angular.forEach($scope.todo.items, function (item) {
                    if (!item.done) { count++ }
                });
                return count;
            }
            $scope.warningLevel = function () {
                return $scope.incompleteCount() < 3 ? "label-success" : "label-warning";
            }
            $scope.addNewItem = function (actionText) {
                $scope.todo.items.push({ action: actionText, done: false });
            }
        });
    </script>
</head>
<body ng-controller="ToDoCtrl">
    <div class="page-header">
        <h1>
            {{todo.user}}'s To Do List
            <span class="label label-default" ng-class="warningLevel()"
                  ng-hide="incompleteCount() == 0">
                {{incompleteCount()}}
            </span>
        </h1>
    </div>
    <div class="panel">
        <div class="input-group">
            <input class="form-control" ng-model="actionText" />
            <span class="input-group-btn">
                <button class="btn btn-default"
                        ng-click="addNewItem(actionText)">Add</button>
            </span>
        </div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Done</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="item in todo.items">
                    <td>{{item.action}}</td>
                    <td><input type="checkbox" ng-model="item.done" /></td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
I have added a behavior called addNewItem that takes the text of a new to-do item and adds an object to the data model, using the text as the value for the action property and setting the doneproperty to false, like this:
...
$scope.addNewItem = function(actionText) {
    $scope.todo.items.push({ action: actionText, done: false});
}




Adding Filtering to the todo.html File
...
<tbody>
    <tr ng-repeat="item in todo.items | filter:{done: false} | orderBy:'action'">
        <td>{{item.action}}</td>
        <td><input type="checkbox" ng-model="item.done" /></td>
    </tr>
</tbody>
...




Creating a Custom Filter in the todo.html File
...
<script>
    var model = {
        user: "Adam",
        items: [{ action: "Buy Flowers", done: false },
                    { action: "Get Shoes", done: false },
                    { action: "Collect Tickets", done: true },
                    { action: "Call Joe", done: false }],
    };
    var todoApp = angular.module("todoApp", []);
    todoApp.filter("checkedItems", function () {
        return function (items, showComplete) {
            var resultArr = [];
            angular.forEach(items, function (item) {
                if (item.done == false || showComplete == true) {
                    resultArr.push(item);
                }
            });
            return resultArr;
        }
    });
    todoApp.controller("ToDoCtrl", function ($scope) {
        $scope.todo = model;
        // ...statements omitted for brevity...
    });
</script>
...
The filtermethod defined by the AngularJS module object is used to create a filter factory, which returns a function that is used to filter a set of data objects. Don’t worry about the factory part for the moment; it is enough to know that using the filtermethod requires passing in a function that returns a function that returns the filtered data. The name I have given my filter is checkedItems, and the function that does the actual filtering has two arguments:
...
return function (items, showComplete) {
...



which I pass to my custom filter through the ng-repeatdirective in the table:
...
<tr ng-repeat="item in todo.items |checkedItems:showComplete| orderBy:'action'">
...
The syntax for custom filters is the same as for the built-in filtering support. I specify the name of the filter I created with the filter method, followed by a colon (:), followed by the name of the model property that I want to pass to the filter function. I have specified the showCompletemodel property, which means that the state of the check box will be used to control the visibility of the checked items. You can see the effect in Figure 2-10.


Making an Ajax Call for JSON Data in the todo.html File
...
<script>
    var model = {
        user: "Adam"
    };
    var todoApp = angular.module("todoApp", []);
    todoApp.run(function ($http) {
        $http.get("todo.json").success(function (data) {
           model.items = data;
        });
    });
    todoApp.filter("checkedItems", function () {
        return function (items, showComplete) {
            var resultArr = [];
            angular.forEach(items, function (item) {
                if (item.done == false || showComplete == true) {
                    resultArr.push(item);
                }
            });
            return resultArr;
        }
    });
    todoApp.controller("ToDoCtrl", function ($scope) {
        $scope.todo = model;
        $scope.incompleteCount = function () {
            var count = 0;
            angular.forEach($scope.todo.items, function (item) {
                if (!item.done) { count++ }
            });
            return count;
        }
        $scope.warningLevel = function () {
            return $scope.incompleteCount() < 3 ? "label-success" : "label-warning";
        }
        $scope.addNewItem = function(actionText) {
            $scope.todo.items.push({ action: actionText, done: false});
        }
    });
</script>
...
I removed the items array from the statically defined data model and added a call to the run method defined by the AngularJS module object. The runmethod takes a function that is executed once AngularJS has performed its initial setup and is used for one-off tasks.


I am going to focus on the standard MVC pattern in this book since it is the most established and widely used.


In broad terms, there are two kinds of web application: round-tripand single-page.



AngularJS excels in single-page applications and especially in complex round-trip applications. For simpler projects, jQuery or a similar alternative is generally a better choice, although nothing prevents you from using AngularJS in all of your projects.
There is a gradual tendency for current web app projects to move toward the single-page application model, and that’s the sweet spot for AngularJS, not just because of the initialization process but because the benefits of using the MVC pattern (which I describe later in this chapter) really start to manifest themselves in larger and more complex projects, which are the ones pushing toward the single-page model.


So, in short, use jQuery for low-complexity web apps where unit testing isn’t critical and you require immediate results. jQuery is also ideal for enhancing the HTML that is generated by round-trip web apps (where user interactions cause a new HTML document to be loaded) because you can easily apply jQuery without needing to modify the HTML content generated by the server. Use AngularJS for more complex single-page web apps, when you have time for careful design and planning and when you can easily control the HTML generated by the server.


The key to applying the MVC pattern is to implement the key premise of a separation of concerns, in which the data model in the application is decoupled from the business and presentation logic. In client-side web development, this means separating the data, the logic that operates on that data, and the HTML elements used to display the data. The result is a client-side application that is easier to develop, maintain, and test.


Patterns are recipes, rather than rules, and you will need to adapt any pattern to suit your specific projects, just like a cook has to adapt a recipe to suit different ovens and ingredients.



The degree by which you depart from a pattern should be driven by experience. The time you have spent applying a pattern to similar projects will inform your knowledge about what does and doesn’t work for you. If you are new to a pattern or you are embarking on a new kind of project, then you should stick as closely as possible to the pattern until you truly understand the benefits and pitfalls that await you. Be careful not to reform your entire development effort around a pattern, however, since wide-sweeping disruption usually causes productivity loses that undermine whatever outcome you were hoping the pattern would give.
Patterns are flexible tools and not fixed rules, but not all developers understand the difference, and some become pattern zealots.These are the people who spend more time talking about the pattern than applying it to projects and consider any deviation from their interpretation of the pattern to be a serious crime.




Understanding Models
Models—the M in MVC—contain the data that users work with. There are two broad types of model: view models, which represent just data passed from the controller to the view, and domain models, which contain the data in a business domain, along with the operations, transformations, and rules for creating, storing, and manipulating that data, collectively referred to as the model logic.



Tip  Many developers new to the MVC pattern get confused with the idea of including logic in the data model, believing that the goal of the MVC pattern is to separate data from logic. This is a misapprehension: The goal of the MVC framework is to divide up an application into three functional areas, each of which may contain both logic anddata. The goal isn’t to eliminate logic from the model. Rather, it is to ensure that the model contains logic only for creating and managing the model data.


The benefits of ensuring that the model is isolated from the controller and views are that you can test your logic more easily


Understanding Controllers
Controllers are the connective tissue in an AngularJS web app, acting as conduits between the data model and views. Controllers add business domain logic (known as behaviors) to scopes, which are subsets of the model.



A controller built using the MVC should
* Contain the logic required to initialize the scope
* Contain the logic/behaviors required by the view to present data from the scope
* Contain the logic/behaviors required to update the scope based on user interaction
The controller should not
* Contain logic that manipulates the DOM (that is the job of the view)
* Contain logic that manages the persistence of data (that is the job of the model)
* Manipulate data outside of the scope
From these lists, you can tell that scopes have a big impact on the way that controllers are defined and used.


Understanding View Data
The domain model isn’t the only data in an AngularJS application. Controllers can create view data(also known as view model data or view models) to simplify the definition of views. View data is not persistent and is created either by synthesizing some aspect of the domain model data or in response to user interaction.



Views cancontain logic, but it should be simple and used sparingly

We don’t want the client-side code accessing the data store directly—doing so would create a tight coupling between the client and the data store that would complicate unit testing and make it difficult to change the data store without also making changes to the client code as well.

There are lots of ways of passing data between the client and the server. One of the most common is to use Asynchronous JavaScript and XML (Ajax) requests to call server-side code, getting the server to send JSON and making changes to data using HTML forms.

REST is a style of API rather than a well-defined specification, and there is disagreement about what exactly makes a web service RESTful. One point of contention is that purists do not consider web services that return JSON to be RESTful. Like any disagreement about an architectural pattern, the reasons for the disagreement are arbitrary and dull and not at all worth worrying about. As far as I am concerned, JSON services areRESTful, and I treat them as such in this book.

In a RESTful web service, the operation that is being requested is expressed through a combination of the HTTP method and the URL. So, for example, imagine a URL like this one:
http://myserver.mydomain.com/people/bob


Tip  It isn’t always possible to create such self-evident URLs in a real project, but you should make a serious effort to keep things simple and not expose the internal structure of the data store through the URL (because this is just another kind of coupling between components). Keep your URLs as simple and clear as possible, and keep the mappings between the URL format and the data store structure within the server.

The URL identifies the data object that I want to operate on, and the HTTP method specifies what operation I want performed,

The GET method is nullipotent, which means that the operations you perform in response to this method should only retrieve data and not modify it. A browser (or any intermediate device, such as a proxy) expects to be able to repeatedly make a GET request without altering the state of the server (although this doesn’t mean the state of the server won’t change between identical GET requests because of requests from other clients).

The PUT and DELETE methods are idempotent, which means that multiple identical requests should have the same effect as a single request. So, for example, using the DELETE method with the /people/bobURL should delete the bobobject from the peoplecollection for the first request and then do nothing for subsequent requests. (Again, of course, this won’t be true if another client re-creates the bob object.)


The POST method is neither nullipotent nor idempotent, which is why a common RESTful optimization is to handle object creation and updates. If there is no bob object, using the POST method will create one, and subsequent POST requests to the same URL will update the object that was created.

Here are the three most common varieties of this problem:
* Putting business logic in views, rather than in controllers
* Putting domain logic in controllers, rather than in model
* Putting data store logic in the client model when using a RESTful service
These are tricky issues because they take a while to manifest themselves as problems. The application still runs, but it will become harder to enhance and maintain over time.


Knowing where to put logic becomes second nature as you get more experience in AngularJS development, but here are the three rules:
* View logic should prepare data only for display and never modify the model.
* Controller logic should never directly create, update, or delete data from the model.
* The client should never directly access the data store.
If you keep these in mind as you develop, you’ll head off the most common problems.

Instead, if you define two functions with the same name, then the second definition replaces the first.

JavaScript is a dynamically typed language. This doesn’t mean JavaScript doesn’t have types. It just means you don’t have to explicitly declare the type of a variable and that you can assign different types to the same variable without any difficulty. JavaScript will determine the type based on the value you assign to a variable and will freely convert between types based on the context in which they are used.

Using global variables in AngularJS development is frowned upon because it undermines the separation of concerns (which I described in Chapter 3) and makes it harder to perform unit testing (which I describe in Chapter 25). As a rule of thumb, if you have to use a global variable to get two components to talk to one another, then something has gone wrong with the application design.


Using the Primitive Types
JavaScript defines a set of primitive types: string, number, and boolean. This may seem like a short list, but JavaScript manages to fit a lot of flexibility into these three types.


The angular.uppercaseand angular.lowercasemethods do exactly as you might imagine,

Using Object Literals
You can define an object and its properties in a single step using the object literal format. Listing 5-14 shows how this is done.
Listing 5-14. Using the Object Literal Format in the jsdemo.html File
<!DOCTYPE HTML>
<html>
<head>
    <title>Example</title>
    <script src="angular.js"></script>
    <script type="text/javascript">
        var myData = {
            name: "Adam",
            weather: "sunny"
        };

        console.log("Hello " + myData.name + ". ");
        console.log("Today is " + myData.weather + ".");
    </script>
</head>
<body>
    This is a simple example
</body>
</html>
Each property that you want to define is separated from its value using a colon (:), and properties are separated using a comma (,).

Extending Objects in the jsdemo.html File
<!DOCTYPE html>
<html>
<head>
    <title>Example</title>
    <script src="angular.js"></script>
    <script type="text/javascript">
        var myData = {
            name: "Adam",
            weather: "sunny",
            printMessages: function () {
                console.log("Hello " + this.name + ". ");
                console.log("Today is " + this.weather + ".");
            }
        };
        var myExtendedObject = {
            city: "London"
        };
        angular.extend(myExtendedObject, myData);
        console.log(myExtendedObject.name);
        console.log(myExtendedObject.city);
    </script>
</head>
<body>
    This is a simple example
</body>
</html>
In this example I create an object with a city property and assign it to the variable called myExtendedObject. I then use the angular.extendmethod to copy all of the properties and functions from the myData object to myExtendedObject. Finally, to demonstrate the mix of original and copied properties, I use the console.logmethod to write out the values of the nameand city properties, producing the following console

 Tip  The extendmethod preserves any properties and methods on the target object. If you want to create a copy of an object without this preservation, then you can use the angular.copymethod instead.


Enumerating an Object’s Properties in the jsdemo.html File
<!DOCTYPE html>
<html>
<head>
    <title>Example</title>
    <script src="angular.js"></script>
    <script type="text/javascript">
        var myData = {
            name: "Adam",
            weather: "sunny",
            printMessages: function () {
                console.log("Hello " + this.name + ". ");
                console.log("Today is " + this.weather + ".");
            }
        };
        for (var prop in myData) {
            console.log("Name: " + prop + " Value: " + myData[prop]);
        }
        console.log("---");
        angular.forEach(myData, function (value, key) {
            console.log("Name: " + key + " Value: " + value);
        });
    </script>
</head>
<body>
    This is a simple example
</body>
</html>
The for...inloop is a standard JavaScript feature and performs the statement in the code block for each property in the myData object. T

Deleting a Property from an Object in the jsdemo.html File
<!DOCTYPE HTML>
<html>
<head>
    <title>Example</title>
    <script src="angular.js"></script>
    <script type="text/javascript">
        var myData = {
            name: "Adam",
            weather: "sunny",
        };
        delete myData.name;
        delete myData["weather"];
        delete myData.SayHello;
    </script>
</head>
<body>
    This is a simple example
</body>
</html>


You can check to see whether an object has a property using the in expression, as shown in Listing 5-23.
Listing 5-23. Checking to See Whether an Object Has a Property in the jsdemo.html File
<!DOCTYPE HTML>
<html>
<head>
    <title>Example</title>
    <script src="angular.js"></script>
    <script type="text/javascript">
        var myData = {
            name: "Adam",
            weather: "sunny",
        };
        var hasName = "name" in myData;
        var hasDate = "date" in myData;
        console.log("HasName: " + hasName);
        console.log("HasDate: " + hasDate);
    </script>
</head>
<body>
    This is a simple example
</body>
</html>
In this example, I test for a property that exists and one that doesn’t. The value of the hasName variable will be true, and the value of the hasDateproperty will be




JavaScript is converting the two operands into the same type and comparing them. In essence, the equality operator tests that values are the same irrespective of their type. If you want to test to ensure that the values and the types are the same, then you need to use the identity operator (===, three equals signs, rather than the two of the equality operator), as shown in Listing 5-26.



Performing Equality and Identity Tests on Objects in the jsdemo.html File
<!DOCTYPE HTML>
<html>
<head>
    <title>Example</title>
    <script src="angular.js"></script>
    <script type="text/javascript">
        var myData1 = {
            name: "Adam",
            weather: "sunny",
        };
        var myData2 = {
            name: "Adam",
            weather: "sunny",
        };
        var myData3 = myData2;
        var test1 = myData1 == myData2;
        var test2 = myData2 == myData3;
        var test3 = myData1 === myData2;
        var test4 = myData2 === myData3;
        console.log("Test 1: " + test1 + " Test 2: " + test2);
        console.log("Test 3: " + test3 + " Test 4: " + test4);
    </script>
</head>
<body>
    This is a simple example
</body>
</html>
The results from this script are as follows:
Test 1: false Test 2: true
Test 3: false Test 4: true
Listing 5-28shows the same tests performed on primitives.
Listing 5-28. Performing Equality and Identity Tests on Objects in the jsdemo.html File
<!DOCTYPE HTML>
<html>
<head>
    <title>Example</title>
    <script src="angular.js"></script>
    <script type="text/javascript">
        var myData1 = 5;
        var myData2 = "5";
        var myData3 = myData2;
        var test1 = myData1 == myData2;
        var test2 = myData2 == myData3;
        var test3 = myData1 === myData2;
        var test4 = myData2 === myData3;
        console.log("Test 1: " + test1 + " Test 2: " + test2);
        console.log("Test 3: " + test3 + " Test 4: " + test4);
    </script>
</head>
<body>
    This is a simple example
</body>
</html>
The results from this script are as follows:
Test 1: true Test 2: true
Test 3: false Test 4: true


Enumerating the Contents of an Array
You enumerate the content of an array using a for loop or the AngularJS angular.forEachmethod, both of which are demonstrated in Listing 5-37.

<!DOCTYPE html>
<html>
<head>
    <title>Example</title>
    <script src="angular.js"></script>
    <script type="text/javascript">
        var myArray = [100, "Adam", true];
        for (var i = 0; i < myArray.length; i++) {
            console.log("Index " + i + ": " + myArray[i]);
        }
        console.log("---");
        angular.forEach(myArray, function (value, key) {
            console.log(key + ": " + value);
        });
    </script>
</head>
<body>
    This is a simple example
</body>
</html>


<!DOCTYPE html>
<html ng-app="demo">
<head>
    <title>Example</title>
    <script src="angular.js"></script>
    <link href="bootstrap.css" rel="stylesheet" />
    <link href="bootstrap-theme.css" rel="stylesheet" />
    <script type="text/javascript">
        var myApp = angular.module("demo", []);
        myApp.controller("demoCtrl", function ($scope, $http) {
            var promise = $http.get("todo.json");
            promise.success(function (data) {
                $scope.todos = data;
            });
        });
    </script>
</head>
<body ng-controller="demoCtrl">
    <div class="panel">
        <h1>To Do</h1>
        <table class="table">
            <tr><td>Action</td><td>Done</td></tr>
            <tr ng-repeat="item in todos">
                <td>{{item.action}}</td>
                <td>{{item.done}}</td>
            </tr>
        </table>
    </div>
</body>
</html>



The key part of the listing is here:
...
var promise = $http.get("todo.json");
promise.success(function (data) {
    $scope.todos = data;
});
...





Encoding and Decoding JSON Data in the jsdemo.html File
<!DOCTYPE html>
<html ng-app="demo">
<head>
    <title>Example</title>
    <script src="angular.js"></script>
    <link href="bootstrap.css" rel="stylesheet" />
    <link href="bootstrap-theme.css" rel="stylesheet" />
    <script type="text/javascript">
        var myApp = angular.module("demo", []);
        myApp.controller("demoCtrl", function ($scope, $http) {
            $http.get("todo.json").success(function (data) {
                var jsonString = angular.toJson(data);
                console.log(jsonString);
                $scope.todos = angular.fromJson(jsonString);
            });
        });
    </script>
</head>
<body ng-controller="demoCtrl">
    <div class="panel">
        <h1>To Do</h1>
        <table class="table">
            <tr><td>Action</td><td>Done</td></tr>
            <tr ng-repeat="item in todos">
                <td>{{item.action}}</td>
                <td>{{item.done}}</td>
            </tr>
        </table>
    </div>
</body>
</html>
In this example, I operate on the data object that is passed to the promise success function. This was received as JSON data from the web server and automatically parsed into a JavaScript array by AngularJS. I then call the angular.toJsonmethod to encode the array as JSON again and write it to the console. Finally, I take the JSON that I have created and call the angular.fromJsonmethod to create another JavaScript object, which I use to populate the data model in the AngularJS controller and populate the table element via the ng-repeat directive.


Filters let you define commonly used data transformations so that they can be applied throughout an application, without being tied to a specific controller or type of data. Filters transform the data as it passes from the scope to the directive but don’t change the source data, allowing you to flexibly format or transform data for display in views.


Why and When to Use Filters
Why
When
Filters contain transformation logic that can be applied to any data in the application for presentation in a view.
Filters are used to format data before it is processed by a directive and displayed in a view.



Applying the currency Filter in the filters.html File
...
<tr ng-repeat="p in products">
    <td>{{p.name}}</td>
    <td>{{p.category}}</td>
    <td>{{p.expiry}}</td>
    <td class="text-right">{{p.price | currency}}</td>
</tr>
...
You can see how easy it is to apply the filter to the data binding. I append the bar symbol (the |character) to the binding source (p.price in this case) followed by the filter name. This is the way that all filters are applied, and you can see the effect in



Using a Different Symbol for the currency Filter in the filters.html File
...
<tr ng-repeat="p in products">
    <td>{{p.name}}</td>
    <td>{{p.category}}</td>
    <td>{{p.expiry}}</td>
    <td class="text-right">{{p.price | currency:"£" }}</td>
</tr>



Applying the number Filter in the filters.html File
...
<tr ng-repeat="p in products">
    <td>{{p.name}}</td>
    <td>{{p.category}}</td>
    <td>{{p.expiry}}</td>
    <td class="text-right">${{p.price | number:0 }}</td>
</tr>
...
I apply the filter using the bar character and the filter name, followed by a colon and then the number of decimal places I want to display. I have specified zero decimal places,



Applying the uppercase and lowercase Filters in the filters.html File
...
<tr ng-repeat="p in products">
    <td>{{p.name | uppercase }}</td>
    <td>{{p.category | lowercase }}</td>
    <td>{{getExpiryDate(p.expiry) | date:"dd MMM yy"}}</td>
    <td class="text-right">${{p.price | number:0 }}</td>
</tr>
...
These filters do exactly what you would expect,



<html ng-app="exampleApp">
<head>
    <title>Filters</title>
    <script src="angular.js"></script>
    <link href="bootstrap.css" rel="stylesheet" />
    <link href="bootstrap-theme.css" rel="stylesheet" />
    <script>
        angular.module("exampleApp", [])
            .controller("defaultCtrl", function ($scope) {
                $scope.products = [
                    { name: "Apples", category: "Fruit", price: 1.20, expiry: 10 },
                    { name: "Bananas", category: "Fruit", price: 2.42, expiry: 7 },
                    { name: "Pears", category: "Fruit", price: 2.02, expiry: 6 },
                    { name: "Tuna", category: "Fish", price: 20.45, expiry: 3 },
                    { name: "Salmon", category: "Fish", price: 17.93, expiry: 2 },
                    { name: "Trout", category: "Fish", price: 12.93, expiry: 4 },
                    { name: "Beer", category: "Drinks", price: 2.99, expiry: 365 },
                    { name: "Wine", category: "Drinks", price: 8.99, expiry: 365 },
                    { name: "Whiskey", category: "Drinks", price: 45.99, expiry: 365 }
                ];
                $scope.limitVal = "5";
                $scope.limitRange = [];
                for (var i = (0 - $scope.products.length);
                        i <= $scope.products.length; i++) {
                    $scope.limitRange.push(i.toString());
                }
            });
    </script>
</head>
<body ng-controller="defaultCtrl">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3>
                Products
                <span class="label label-primary">{{products.length}}</span>
            </h3>
        </div>
        <div class="panel-body">
            Limit: <select ng-model="limitVal"
                ng-options="item for item in limitRange"></select>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-bordered table-condensed">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Category</td>
                        <td>Expiry</td>
                        <td class="text-right">Price</td>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="p in products | limitTo:limitVal">
                        <td>{{p.name}}</td>
                        <td>{{p.category}}</td>
                        <td>{{p.expiry}}</td>
                        <td class="text-right">{{p.price | currency }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>


Selecting items in the filters.html file
...
<tr ng-repeat="p in products | filter:{category: 'Fish'}">
    <td>{{p.name}}</td>
    <td>{{p.category}}</td>
    <td>{{p.expiry}}</td>
    <td class="text-right">{{p.price | currency }}</td>
</tr>
...
I have used the map object approach in this example, specifying that I want to select those items whose categoryproperty is Fish. If you filter using a function, the selected items will be those for which the function returns true, as shown in Listing 14-11.



<html ng-app="exampleApp">
<head>
    <title>Filters</title>
    <script src="angular.js"></script>
    <link href="bootstrap.css" rel="stylesheet" />
    <link href="bootstrap-theme.css" rel="stylesheet" />
    <script>
        angular.module("exampleApp", [])
            .controller("defaultCtrl", function ($scope) {
                $scope.products = [
                    { name: "Apples", category: "Fruit", price: 1.20, expiry: 10 },
                    { name: "Bananas", category: "Fruit", price: 2.42, expiry: 7 },
                    { name: "Pears", category: "Fruit", price: 2.02, expiry: 6 },
                    { name: "Tuna", category: "Fish", price: 20.45, expiry: 3 },
                    { name: "Salmon", category: "Fish", price: 17.93, expiry: 2 },
                    { name: "Trout", category: "Fish", price: 12.93, expiry: 4 },
                    { name: "Beer", category: "Drinks", price: 2.99, expiry: 365 },
                    { name: "Wine", category: "Drinks", price: 8.99, expiry: 365 },
                    { name: "Whiskey", category: "Drinks", price: 45.99, expiry: 365 }
                ];
                $scope.limitVal = "5";
                $scope.limitRange = [];
                for (var i = (0 - $scope.products.length) ;
                        i <= $scope.products.length; i++) {
                    $scope.limitRange.push(i.toString());
                }
                $scope.selectItems = function (item) {
                    return item.category == "Fish" || item.name == "Beer";
                };
            });
    </script>
</head>
<body ng-controller="defaultCtrl">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3>
                Products
                <span class="label label-primary">{{products.length}}</span>
            </h3>
        </div>
        <div class="panel-body">
            Limit: <select ng-model="limitVal"
                           ng-options="item for item in limitRange"></select>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-bordered table-condensed">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Category</td>
                        <td>Expiry</td>
                        <td class="text-right">Price</td>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="p in products | filter:selectItems">
                        <td>{{p.name}}</td>
                        <td>{{p.category}}</td>
                        <td>{{p.expiry}}</td>
                        <td class="text-right">{{p.price | currency }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>





<tr ng-repeat="p in products | orderBy:'price'">
    <td>{{p.name}}</td>
    <td>{{p.category}}</td>
    <td>{{p.expiry}}</td>
    <td class="text-right">{{p.price | currency }}</td>
</tr>
...


Caution  Notice that I have surrounded the property name with quotes: 'price' and not just price. The orderBy filter will quietly fail if you forget the quotes when hardwiring a property name into a directive expression. Without the quotes, the filter assumes you want to use a scope variable or a controller variable called price and figures that you’ll get around to defining it at some point in the future.



Explicitly Setting the Sort Direction in the filters.html File
...
<tr ng-repeat="p in products | orderBy:'-price'">
...
By prefixing the property name with a minus sign (-) I specify that the objects should be sorted in descending order of their price property, as shown in Figure 14-12. Specifying a plus sign (+) is equivalent to no prefix at all and has the effect of applying an ascending sort.


   $scope.myCustomSorter = function (item) {
                return item.expiry < 5 ? 0 : item.price;
            }
        });
</script>
...
Functions used for sorting are passed an object from the data array and return an object or value that will be used for comparison during sorting. In this function, I return the value of the priceproperty unless the value of the expiryproperty is less than 5, in which case I return zero. The effect of this function is that items with a small expiryvalue will be placed near the start of the data array for ascending sorts. In Listing 14-15, you can see how I have applied the function to the orderBy filter.
Listing 14-15. Applying the Search Function in the filters.html File
...
<tr ng-repeat="p in products | orderBy:myCustomSorter">
    <td>{{p.name}}</td>
    <td>{{p.category}}</td>
    <td>{{p.expiry}}</td>
    <td class="text-right">{{p.price | currency }}</td>
</tr>
...
Notice that I don’t surround the name of the function with quotes, as I did when I specified a property name as a literal string.

...
<tr ng-repeat="p in products | orderBy:[myCustomSorter, '-price']">
    <td>{{p.name}}</td>
    <td>{{p.category}}</td>
    <td>{{p.expiry}}</td>
    <td class="text-right">{{p.price | currency }}</td>
</tr>
...



Chaining Filters in the filters.html File
...
<tr ng-repeat="p in products | orderBy:[myCustomSorter, '-price'] | limitTo: 5">
    <td>{{p.name}}</td>
    <td>{{p.category}}</td>
    <td>{{p.expiry}}</td>
    <td class="text-right">{{p.price | currency }}</td>
</tr>
...

Tip  You can chain together filters that operate on single data values, but there isn’t much point in doing this with the built-in filters like currencyand date, s


Creating a Filter That Formats a Data Value
Filters are created by the Module.filtermethod, which takes two arguments: the name of the filter that will be created and a factory function that creates the worker function that will undertake the actual work.



The Contents of the customFilters.js File
angular.module("exampleApp")
    .filter("labelCase", function () {
        return function (value, reverse) {
            if (angular.isString(value)) {
                var intermediate =  reverse ? value.toUpperCase() : value.toLowerCase();
                return (reverse ? intermediate[0].toLowerCase() :
                    intermediate[0].toUpperCase()) + intermediate.substr(1);
            } else {
                return value;
            }
        };
    });



Applying a Custom Filter to the filters.html File
...
<tr ng-repeat="p in products | orderBy:[myCustomSorter, '-price'] | limitTo: 5">
    <td>{{p.name | labelCase }}</td>
    <td>{{p.category | labelCase:true }}</td>
    <td>{{p.expiry}}</td>
    <td class="text-right">{{p.price | currency }}</td>
</tr>
...
I have not specified a configuration option when applying the filter to the nameproperty, which means that AngularJS will pass null as the value for the second argument to the filter worker function.


angular.module("exampleApp")
    .filter("labelCase", function () {
        return function (value, reverse) {
            if (angular.isString(value)) {
                var intermediate =  reverse ? value.toUpperCase() : value.toLowerCase();
                return (reverse ? intermediate[0].toLowerCase() :
                    intermediate[0].toUpperCase()) + intermediate.substr(1);
            } else {
                return value;
            }
        };
    })
    .filter("skip", function () {
        return function (data, count) {
            if (angular.isArray(data) &&angular.isNumber(count)) {
                if (count > data.length || count < 1) {
                    return data;
                } else {
                    return data.slice(count);
                }
            } else {
                return data;
            }
        }
    });



...
<tr ng-repeat="p in products | skip:2 | limitTo: 5">
    <td>{{p.name}}</td>
    <td>{{p.category}}</td>
    <td>{{p.expiry}}</td>
    <td class="text-right">{{p.price | currency }}</td>
</tr>
...
I have chained the skip and limitTofilters to emphasize that custom filters are used in just the same way as the built-in ones.


angular.module("exampleApp")

    .filter("labelCase", function () {

        //...statements omitted for brevity...

    })

    .filter("skip", function () {

        //...statements omitted for brevity...

    })

    .filter("take", function ($filter) {

        return function (data, skipCount, takeCount) {

            var skippedData = $filter("skip")(data, skipCount);

            return $filter("limitTo")(skippedData, takeCount);

        }

    });


...

<tr ng-repeat="p in products | take:2:5">

    <td>{{p.name}}</td>

    <td>{{p.category}}</td>

    <td>{{p.expiry}}</td>

    <td class="text-right">{{p.price | currency }}</td>

</tr>

...
AngularJS comes with more than 50 built-in directives that provide access to core features that are useful in almost every web application including data binding, form validation, template generation, event handling, and manipulating HTML elements.


I created a module called exampleApp using the angular.module method and then used the fluent API to define a controller called defaultCtrl. The controller uses the $scope service to add some data items to the data model, and the module and the controller are applied to HTML elements with the ng-app and ng-controllerdirectives.


AngularJS supports two kinds of data binding. The first, one-way binding, means a value is taken from the data model and inserted into an HTML element. AngularJS bindings are live, which means that when the value associated with the binding is changed in the data model, the HTML element will be updated to display the new value.
The ng-bind directive is responsible for creating one-way data bindings, but it is rarely used directly because AngularJS will also create this kind of binding whenever it encounters the {{ and }} characters in the HTML document. Listing 10-2shows the different ways you can create one-way data bindings.

I generally prefer to apply directives as attributes, as follows:
...

There are <span ng-bind="todos.length"></span> items

...
The directive is specified as the attribute name, ng-bindin this case, and the configuration for the directive is set as the attribute value.
If you can’t or won’t use custom attributes, then you can configure directives using the standard class attribute, as follows:
...

There are <span class="ng-bind: todos.length"></span> items

...
The value of the class attribute is the name of the directive, followed by a colon, followed by the configuration for the directive. This statement has the same effect as the last one


        <div>There are {{todos.length}} items</div>



        <div>

            There are <span ng-bind="todos.length"></span> items

        </div>



        <div ng-bind-template=

            "First: {{todos[0].action}}. Second: {{todos[1].action}}">

        </div>



        <div ng-non-bindable>

            AngularJS uses {{ and }} characters for templates

        </div>


The solution is to use the ng-non-bindable directive, which prevents AngularJS from processing inline bindings:
...

<div ng-non-bindable>

    AngularJS uses {{ and }} characters for templates

</div>

...

Two-way bindings are created with the ng-model directive


Creating Two-Way Bindings in the directives.html File
...

<body>

    <div id="todoPanel" class="panel" ng-controller="defaultCtrl">

        <h3 class="panel-header">To Do List</h3>

        <div class="well">

            <div>The first item is: {{todos[0].action}}</div>

        </div>


        <div class="form-group well">

            <label for="firstItem">Set First Item:</label>

            <input name="firstItem" class="form-control" ng-model="todos[0].action" />

        </div>

    </div>

</body>

...
There are two data bindings in this listing, both of which are applied to the action property of the first object in the todos data array (which I set up using the $scope object in the controller and reference in bindings as todos[0].action). The first binding is an inline one-way binding that simply displays the value of the data property, just as I did in the previous example. The second binding is applied via the inputelement and is a two-way binding:
...

<input name="firstItem" class="form-control" ng-model="todos[0].action"/>

...
Two-way bindings can be applied only to elements that allow the user to provide a data value, which means the input, textarea, and select elements. The ng-model directive sets the content of the element it is applied to and then responds to changes that the user makes by updating the data model.


OK, two-way bindings are not really magic. AngularJS uses standard JavaScript events to receive notifications from the input element when its content changes and propagates these changes via the $scope service. You can see the event handler that AngularJS sets up through the F12 developer tools, and I explain how the $scope service detects and disseminates changes


The Template Directives

Directive

Applied As

Description

ng-cloak

Attribute, class

Applies a CSS style that hides inline binding expressions, which can be briefly visible when the document first loads

ng-include

Element, attribute, class

Loads, processes, and inserts a fragment of HTML into the Document Object Model

ng-repeat

Attribute, class

Generates new copies of a single element and its contents for each object in an array or property on an object

ng-repeat-start

Attribute, class

Denotes the start of a repeating section with multiple top-level elements

ng-repeat-end

Attribute, class

Denotes the end of a repeating section with multiple top-level elements

ng-switch

Element, attribute

Changes the elements in the Document Object Model based on the value of data bindings



These directives help you put simple logic into views without having to write any JavaScript code. As I explained in Chapter 3, the logic in views should be restricted to generating the content required to display data, and these directives all fit into that definition.

...
<tr ng-repeat="item in todos">
...
The basic format of the value for the ng-repeat directive attribute is <variable> in <source>, where source is an object or array defined by the controller $scope, in this example the todos array. The directive iterates through the objects in the array, creates a new instance of the element and its content, and then processes the templates it contains. The <variable> name assigned in the directive attribute value can be used to refer to the current data object.



Receiving a Key Along with a Data Value in the directives.html File

...
<tr ng-repeat="item in todos">

    
<td ng-repeat="(key, value) in item">

        
{{key}}={{value}}

    
</td>
</tr>
…

<tr ng-repeat="item in todos">
        <td>{{$index + 1}}</td>
        <td ng-repeat="prop in item">
            {{prop}}
        </td>
    </tr>
</table>
...
I added a new column to the table that contains the to-do items and used the $index variable, which is provided by the ng-repeat directive, to display the position of each item in the array. Since JavaScript collec



The Built-in ng-repeat Variables









Variable

Description

$index

Returns the position of the current object or property

$first

Returns true if the current object is the first in the collection

$middle

Returns true if the current object is neither the first nor last in the collection

$last

Returns true if the current object is the last in the collection

$even

Returns true for the even-numbered objects in a collection

$odd

Returns true for the odd-numbered objects in a collection

Stripped table:
<tr ng-repeat="item in todos" ng-class="$odd ? 'odd' : 'even'">
                <td>{{$index + 1}}</td>
                <td ng-repeat="prop in item">{{prop}}</td>
As the listing illustrates, the name of the directive is used as the element tag name, like this:

...
< ng-includesrc="'table.html'"></ng-include>
...
Caution  Don’t try to use apply the ng-include directive as a void element (in other words, <ng-include src="'table.html'" />). The content that follows the ng-include element will be removed from the DOM. You must always specify open and close tags, as I have shown in the example.

My previous example demonstrated how the ng-includedirective can be used to break a view into multiple partial view files. This is, in and of itself, a useful feature, and it allows you to create reusable partial views that can be applied throughout an application to avoid duplication and ensure consistent presentation of data.
The Contents of the list.html File

<ol>
    <li ng-repeat="item in todos">
        {{item.action}}
        <span ng-if="item.complete"> (Done)</span>
    </li>
</ol>
Using the ng-include Directive to Process Fragments Dynamically in the directives.html File

<!DOCTYPE html>
<html ng-app="exampleApp">
<head>
    <title>Directives</title>
    <script src="angular.js"></script>
    <link href="bootstrap.css" rel="stylesheet" />
    <link href="bootstrap-theme.css" rel="stylesheet" />
    <script>
        angular.module("exampleApp", [])
            .controller("defaultCtrl", function ($scope) {
                $scope.todos = [
                    { action: "Get groceries", complete: false },
                    { action: "Call plumber", complete: false },
                    { action: "Buy running shoes", complete: true },
                    { action: "Buy flowers", complete: false },
                    { action: "Call family", complete: false }];
 
                $scope.viewFile = function () {
                    return $scope.showList ? "list.html" : "table.html";
                };
            });
    </script>
</head>
<body>
    <div id="todoPanel" class="panel" ng-controller="defaultCtrl">
        <h3 class="panel-header">To Do List</h3>
 
        <div class="well">
            <div class="checkbox">
                <label>
                    <input type="checkbox" ng-model="showList">
                    Use the list view
                </label>
            </div>
        </div>
 
        <ng-include src="viewFile()"></ng-include>
 
    </div>
</body>
</html>
I have defined a behavior called viewFile in the controller that returns the name of one of the two fragment files I created based on the value of a variable called showList. If showList is true, then the viewFile behavior returns the name of the list.html file; if showList is false or undefined, then the behavior returns the name of the table.html file.

The showList variable is initially undefined, but I have added a check box input element that sets the variable when it is checked using the ng-model directive, which I described earlier in this chapter. The user can change the value of the showList variable by checking or unchecking the element.

The ng-switch directive is applied with an on attribute that specifies the expression that will be evaluated to decide which region of content will be displayed, as follows:

...
<div ng-switch on="data.mode">
...
In this example, I have specified that the value of the data.mode model property—the one that the radio buttons manage—will be used. You then use the ng-switch-whendirective to denote a region of content that will be associated with a specific value, like this:

...
<div ng-switch-when="Table">
    <table class="table">
        <!--elements omitted for brevity-->
    </table>
</div>
<div ng-switch-when="List">
    <ol>
        <!--elements omitted for brevity-->
    </ol>
</div>
...
AngularJS will show the element to which the ng-switch-when directive has been applied when the attribute value matches the expression defined by the on attribute. The other elements within the ng-switch directive block are removed. The ng-switch-default directive is used to specify content that should be displayed when none of the ng-switch-whensections matches, as follows:

...
<div ng-switch-default>

    
Select another option to display a layout
</div>
…

Use ng-switch when you need to alternate between smaller, simpler blocks of content and that there is a good chance the user will be shown most or all of those blocks in the normal execution of the web app. This is because you have to deliver all the content that the ng-switchdirective needs as part of the HTML document, and that’s a waste of bandwidth and loading time for content that is unlikely to be used.

The ng-include attribute is better suited for more complex content or content that you need to use repeatedly throughout an application. Partial views can help reduce the amount of duplication in a project when you need to include the same content in different places, but you must bear in mind that partial views are not requested until the first time they are required, and this can cause delays while the browser makes the Ajax request and receives the response from the server.
A better alternative is to use the ng-cloak directive, which has the effect of hiding content until AngularJS has finished processing it. The ng-cloak directive uses CSS to hide the elements to which it is applied, and the AngularJS library removes the CSS class when the content has been processed, ensuring that the user never sees the {{ and }} characters of a template expression. You can apply the ng-cloak directive as broadly or selectively as you want. A common approach is to apply the directive to the body element, but that just means that the user sees an empty browser window while AngularJS processes the content. I prefer to be more selective and apply the directive only to the parts of the document where there are inline expressions, as shown in Listing 10-18.

Selectively Applying the ng-cloak Directive to the directives.html File

...
<body>
    <div id="todoPanel" class="panel" ng-controller="defaultCtrl">
        <h3 class="panel-header">To Do List</h3>
 
        <div class="well">
            <div class="radio" ng-repeat="button in ['None', 'Table', 'List']">
                <label ng-cloak>
                    <input type="radio" ng-model="data.mode"
                        value="{{button}}" ng-checked="$first">
                    {{button}}
                </label>
            </div>
        </div>
 
        <div ng-switch on="data.mode" ng-cloak>
            <div ng-switch-when="Table">
                <table class="table">
                    <thead>
                        <tr><th>#</th><th>Action</th><th>Done</th></tr>
                    </thead>
                    <tr ng-repeat="item in todos" ng-class="$odd ? 'odd' : 'even'">
                        <td>{{$index + 1}}</td>
                        <td ng-repeat="prop in item">{{prop}}</td>
                    </tr>
                </table>
            </div>
            <div ng-switch-when="List">
                <ol>
                    <li ng-repeat="item in todos">
                        {{item.action}}<span ng-if="item.complete"> (Done)</span>
                    </li>
                </ol>
            </div>
            <div ng-switch-default>
                Select another option to display a layout
            </div>
        </div>
    </div>
</body>
...
Applying the directive to the sections of the document that contain template expressions leaves the user able to see the static structure of a page, which still isn’t ideal but is a lot better than just an empty window. You can see the effect the directive creates in Figure 10-10 (and, of course, the full app layout is revealed to the user when AngularJS finishes processing the content).



Using the Element Directives

The first set of directives that I describe in this chapter are used to configure and style elements in the Document Object Model (DOM). These directives are useful for managing the way that an application displays content and data and, since this is AngularJS, for using bindings to change the HTML document dynamically when the data model changes.



The Element Directives










Directive

Applied As

Description

ng-if

Attribute

Adds and removes elements from the DOM

ng-class

Attribute, class

Sets the class attribute for an element

ng-class-even

Attribute, class

Sets the class attribute for even-numbered elements generated within the ng-repeatdirective

ng-class-odd

Attribute, class

Sets the class attribute for odd-numbered elements generated within the ng-repeatdirective

ng-hide

Attribute, class

Shows and hides elements in the DOM

ng-show

Attribute, class

Shows and hides elements in the DOM

ng-style

Attribute, class

Sets one or more CSS properties

Many of the directives in this category control whether elements are visible to the user, either by hiding them or by removing them completely from the DOM.

Why and When to Create Custom Directives




Why

When

Custom directives let you create functionality that goes beyond the built-in directives that AngularJS provides.

You create custom directives when the built-in directives don’t do what you want or when you want to create self-contained functionality that you can reuse in different applications.

Defining the Directive

Directives are created using the Module.directive method, and the arguments are the name of the new directive and a factory function that creates the directive.

    

