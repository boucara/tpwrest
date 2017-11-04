

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'api_rest.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'api_rest.UserAuthority'
grails.plugin.springsecurity.authority.className = 'api_rest.Authority'
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/dbconsole/*',    access: ['permitAll']],
	[pattern: '/login',      access: ['permitAll']],
	[pattern: '/logout',     access: ['isFullyAuthenticated()']],
	[pattern: '/**',             access: ['isFullyAuthenticated()']]

]
grails.plugin.springsecurity.interceptUrlMap = [
		[pattern: '/',               access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],
		[pattern: '/dbconsole/*',    access: ['permitAll']],
		[pattern: '/login/*',      access: ['permitAll']],
		[pattern: '/logout/*',     access: ['isFullyAuthenticated()']],
		[pattern: '/**',             access: ['isFullyAuthenticated()']],
		[pattern: '/api/bibliotheque',    access: ['isFullyAuthenticated()']],
		[pattern: '/api/bibliotheques',    access: ['isFullyAuthenticated()']],
		[pattern: '/api/livre',    access: ['isFullyAuthenticated()']],
		[pattern: '/api/livres',    access: ['isFullyAuthenticated()']],

]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	//[pattern: '/**',             filters: 'JOINED_FILTERS'],
	[pattern: '/api/**', filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter'],
	[pattern: '/**', filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']

]
grails.plugin.springsecurity.rest.logout.endpointUrl = '/logout'
grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
grails.plugin.springsecurity.rest.token.validation.headerName = 'MyToken'
grails.plugin.springsecurity.rest.token.storage.memcached.hosts = 'localhost:08080'
grails.plugin.springsecurity.rest.token.storage.memcached.username = ''
grails.plugin.springsecurity.rest.token.storage.memcached.password = ''
grails.plugin.springsecurity.rest.token.storage.memcached.expiration = 86400

