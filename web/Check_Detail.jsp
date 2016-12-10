            <div ng-controller="CheckC">
                <p ng-init="PDetail()">Search</p>
                <input type="text" ng-model="search" placeholder="Enter Name"/>
                <table border="1px">
                    <thead>
                        <th>S.No.</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>City</th>
                        <th>Delete</th>
                    </thead>
                    <tr ng-repeat="x in Item | filter:search">
                        <td>{{$index+1}}</td>
                        <td>{{x.name}}</td>
                        <td>{{x.age}}</td>
                        <td>{{x.city}}</td>
                        <td ng-click="Remove(x.id);PDetail()">&times;</td>
                    </tr>
                </table>
            </div>   