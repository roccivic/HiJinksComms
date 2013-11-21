<nav>
  <ul data-role="listview" data-theme="c" data-dividertheme="d">
    <li data-role="list-divider">Main Menu
    </li>
    <li data-icon="plus" data-theme="b">
      <a href="<%= request.getContextPath() %>/createCommunity">Create Community</a>
    </li>
    <li data-icon="search" data-theme="b">
      <a href="<%= request.getContextPath() %>/search">Search</a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/newestCommunities">Newest Communities</a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/communitiesYouOwn">Communities You Own</a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/communitiesYouArePartOf">Communities You Are Part Of</a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/requests">Your Requests</a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/invitations">Your Invitations</a>
    </li>
    <li>
      <a href="<%= request.getContextPath() %>/users">View Users</a>
    </li>
  </ul>
</nav>