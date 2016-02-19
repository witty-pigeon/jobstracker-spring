<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page pageEncoding="UTF-8" %>
<t:generic title="Positions tracker" useAngular="true">
  <ng-view></ng-view>
  <div class="message-area">
    <div class="alert" ng-repeat="message in messages"
      ng-class="{'alert-success': message.type === 'success',
                'alert-info': message.type === 'info',
                'alert-danger': message.type === 'error',
                'alert-warning': message.type === 'warning'}">
           {{message.message}}
     <span class="glyphicon glyphicon-remove" style="float:right; cursor:pointer"
           ng-click="removeMessage($index)"></span>
     <span style="float:right">{{message.timeLong | date:'mediumTime'}}&nbsp;</span>
    </div>
  </div>
</t:generic>