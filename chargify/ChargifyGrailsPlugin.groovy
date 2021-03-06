class ChargifyGrailsPlugin {
    // the plugin version
    def version = "1.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.4 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def author = "Salil Kalia"
    def authorEmail = "salil@intelligrape.com, anshul@intelligrape.com"
    def title = "Grails Chargify Plugin"
    def description = '''\\
The plugin is created using grails 1.3.4 and provide your application the simplified intermediate service
to integrate the use of the web-services provided by the chargify that manages the billing for your
subscriptions-based business into your application.
For more details please check out the documentation - http://github.com/IntelliGrape/Grails-Chargify-Plugin/wiki
'''

    // URL to the plugin's documentation
    def documentation = "http://github.com/IntelliGrape/Grails-Chargify-Plugin/wiki"

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before 
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
