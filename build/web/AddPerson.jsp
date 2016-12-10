<div ng-controller="AddC">
                <form ng-submit="AddP()">
                    <input type="text" ng-model="newItem.name" placeholder="Name"/><br/>
                    <input type="text" ng-model="newItem.age" placeholder="Age"/><br/>
                    <input type="text" ng-model="newItem.city" placeholder="City"/><br/>
                    <button type="submit"> ADD </button>
                </form>
</div>
     {{msg}}
      