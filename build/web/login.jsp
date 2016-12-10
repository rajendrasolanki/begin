    <div ng-controller="LoginC">
                <form ng-submit="Login()">
                    <input type="text" ng-model="User.name" placeholder="Username"/><br/>
                    <input type="password" ng-model="User.pass" placeholder="Password"/><br/>
                    <button type="submit"> Log In </button>
                </form>
            </div>