class NcsNorcLinkGrailsPlugin {
    // the plugin version
    def version = "0.6"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"
    // the other plugins this plugin depends on
    def dependsOn = [ ncsTracking : "3.2.6 > *", ncsPeople : "1.0 > *" ]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp",
			"grails-app/conf/*",
			"lib/"
    ]

    def author = "Aaron J. Zirbes"
    def authorEmail = "ajz@umn.edu"
    def title = "NCS NORC entity linking"
    def description = '''\\
Domain classes necessary for linking internal entities to external NORC identities.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/ncs-norc-link"

}
