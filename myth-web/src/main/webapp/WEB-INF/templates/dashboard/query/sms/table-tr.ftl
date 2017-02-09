<#assign ctx="${(rca.contextPath)!''}">

<tr id="sms-${sms.id}">
    <td>${sms.id}</td>
    <td>${sms.mobile}</td>
    <td>${sms.token}</td>
    <td>${sms.code}</td>
    <td><@c.relative_date datetime=sms.createdTime/></td>
    <td>${sms.expireTime?datetime}</td>
    <td>${sms.errMsg}[${sms.errCo}]</td>
    <td title="${sms.result}"><@c.substring str="${sms.result}" len=66/></td>
</tr>