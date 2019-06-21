### About
This repository implements a Spring Boot Multitenancy example.
Each tenant uses different databases, it's the highest level os isolation.
It also implements multitenancy Cache, it's differencial is that each tenant will have it's own cache namespace,
a example, if you have two tenants, TenantOne and TenantTwo, and you declare a cacheable method with it's name as employee,
behind the scenes, your application will have two caches, TenantOne.employee and TenantTwo.employee.