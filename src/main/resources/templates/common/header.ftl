<#macro scripts>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/sign.css">
    <link rel="stylesheet" type="text/css" href="/css/sticky-footer.css">
    <link rel="stylesheet" type="text/css" href="/css/album.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" integrity="sha384-2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj" crossorigin="anonymous">
    <script src="http://code.jquery.com/jquery-2.1.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/js/bootstrap.min.js" integrity="sha384-VjEeINv9OSwtWFLAtmc4JCtEJXXBub00gtSnszmspDLCtC0I4z4nqz7rEFbIZLLU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/lodash/4.15.0/lodash.min.js"></script>
    <script src="/js/main.js"></script>
</#macro>
<#macro header>
    <nav class="navbar navbar-fixed-top navbar-dark bg-primary">
        <button class="navbar-toggler hidden-sm-up pull-right" type="button" data-toggle="collapse" data-target="#collapsingNavbar">
            ☰
        </button>
        <a class="navbar-brand" href="/">HC</a>
        <div class="collapse navbar-toggleable-xs" id="collapsingNavbar">
            <ul class="nav navbar-nav pull-right">
                <div class="col-md-4">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Healthcare <span class="sr-only">Healthcare</span></a>
                    </li>
                </div>
                <div class="col-md-4">
                    <form class="form-inline pull-xs-right">
                        <input class="form-control" type="text" placeholder="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
                <div class="col-md-3">
                    <li class="nav-item">
                        <a class="nav-link" href="#features">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#myAlert" data-toggle="collapse">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/account/" >Account</a>
                    </li>
                </div>
            </ul>
        </div>
    </nav>
</#macro>