<nav>
  <ul data-role="listview" data-theme="c" data-dividertheme="d" data-count-theme="e">
    <li data-role="list-divider">
    	Main Menu
    </li>
    <li data-icon="plus" data-theme="b">
      <a href="<%= request.getContextPath() %>/createCommunity">
      	Create Community
      </a>
    </li>
    <li data-icon="search" data-theme="b">
      <a href="<%= request.getContextPath() %>/search">
      	Search
      </a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/newestCommunities">
      	Newest Communities
      	<span class="ui-li-count">${menu.newestCommunities}</span>
       </a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/communitiesYouOwn">
      	Communities You Own
      	<span class="ui-li-count">${menu.communitiesYouOwn}</span>
      </a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/communitiesYouArePartOf">
      	Communities You Are Part Of
      	<span class="ui-li-count">${menu.communitiesYouArePartOf}</span>
      </a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/requests">
      	Your Requests
      	<span class="ui-li-count">${menu.requests}</span>
      </a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/invitations">
      	Your Invitations
      	<span class="ui-li-count">${menu.invitations}</span>
      </a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/users">
      	View Users
      	<span class="ui-li-count">${menu.users}</span>
      </a>
    </li>
  </ul>
</nav>