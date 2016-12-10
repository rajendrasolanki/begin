<div ng-controller="SignUpC">
                <form ng-submit="SignUp()">
                    <input type="email" ng-model="newUser.uname" placeholder="Enter Your Mail Id " required/><br/>
                    <input type="password" ng-model="newUser.pass" placeholder="Enter Password " required/><br/>
                    <input type="password" ng-model="newUser.pass1" placeholder="Confirm Password" required/><br/>
                    <button type="submit"> ADD </button>
                </form>
    {{msg}}
</div>