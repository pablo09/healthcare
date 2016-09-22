<#import "../common/templatePage.ftl" as template>
<#import "/spring.ftl" as spring />

<@template.page>
<div class="container">

    <form class="form-signin" action="/account/login" method="post">
        <h2 class="form-signin-heading"><@spring.message 'account.label'/></h2>
        <label for="name" class="sr-only"><@spring.message 'account.email'/></label>
        <input type="email" id="email" name="email" class="form-control" placeholder="<@spring.message 'account.email'/>" required="" autofocus="">
        <label for="inputPassword" class="sr-only"><@spring.message 'account.password'/></label>
        <input type="password" id="password" name="password" class="form-control" placeholder="<@spring.message 'account.password'/>" required="">
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> <@spring.message 'account.remember'/>
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><@spring.message 'account.sign'/></button>
    </form>

    <#if error.isPresent()>
        <p><@spring.message 'account.login.error'/></p>
    </#if>
</div>
</@template.page>