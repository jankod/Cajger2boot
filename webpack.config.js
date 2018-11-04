var Encore = require('@symfony/webpack-encore');

let dirSrc = "./src/main/resources/static/src";


Encore
// directory where compiled assets will be stored
    .setOutputPath(dirSrc + '/../dist/')
    // public path used by the web server to access the output path
    .setPublicPath('/')
    // only needed for CDN's or sub-directory deploy
    //.setManifestKeyPrefix('build/')

    /*
     * ENTRY CONFIG
     *
     * Add 1 entry for each "page" of your app
     * (including one that's included on every page - e.g. "app")
     *
     * Each entry will result in one JavaScript file (e.g. app.js)
     * and one CSS file (e.g. app.css) if you JavaScript imports CSS.
     */
    .addEntry('index', dirSrc + '/index.js')
    //.addEntry('fullcalendar', dirSrc+'/fullcalendar.js')
    //.addEntry('bootstrap_jquery', dirSrc+'/bootstrap_jquery.js')
    .createSharedEntry("bootstrap_jquery", dirSrc+'/bootstrap_jquery.js')


    .cleanupOutputBeforeBuild()
    .enableSourceMaps(!Encore.isProduction())
    // enables hashed filenames (e.g. app.abc123.css)
    .enableVersioning(Encore.isProduction())

    // uncomment if you use TypeScript
    //.enableTypeScriptLoader()

    // uncomment if you use Sass/SCSS files
    .enableSassLoader()

    // uncomment if you're having problems with a jQuery plugin
    .autoProvidejQuery()
;

module.exports = Encore.getWebpackConfig();