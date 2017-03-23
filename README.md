# Threat Manager Plugin for Graylog2

[![Build Status](https://travis-ci.org/billmurrin/graylog-plugin-threat-manager.svg?branch=master)](https://travis-ci.org/billmurrin/graylog-plugin-threat-manager)

This plugin is still being conceptualized and is currently in **ALPHA**.

The Threat Manager Plugin provides a Graphical Interface for managing and creating lists of threat indicators inside of Graylog which can be applied to streams.

Installation
------------
[Download the plugin](https://github.com/billmurrin/graylog-plugin-threat-manager/releases/)
and place the `.jar` file in your Graylog plugin directory. The plugin directory
is the `plugins/` folder relative from your `graylog-server` directory by default
and can be configured in your `graylog.conf` file.

Restart `graylog-server` and you are done.

Development
-----------
You can improve your development experience for the web interface part of your plugin
dramatically by making use of hot reloading. To do this, do the following:

* `git clone https://github.com/Graylog2/graylog2-server.git`
* `cd graylog2-server/graylog2-web-interface`
* `ln -s $YOURPLUGIN plugin/`
* `npm install && npm start`

If you run into issues with the current snapshot you can clone the 2.2.2 version of Graylog by using the following:

`git clone -b "2.2.2" https://github.com/Graylog2/graylog2-server.git`

**TIP** If you happen to use "[graylog-project](https://github.com/Graylog2/graylog-project)" and are having issues with the plugin compiling properly or not loading on the page, ensure your plugin's package.json has the same dependcies as "[graylog-plugin-sample](https://github.com/Graylog2/graylog-plugin-sample)". The example below has a few additional packages (crossfilter, d3, dc, deep-equal and immutable).

```
 "dependencies": {
    "reflux": "^0.2.12",
    "crossfilter": "1.3.x",
    "d3": "<=3.5.0",
    "dc": "2.0.0-beta.19",
    "deep-equal": "^1.0.1",
    "immutable": "^3.7.5"
  },
  "devDependencies": {
    "babel-core": "^6.0.0",
    "babel-loader": "^6.0.0",
    "babel-plugin-add-module-exports": "^0.2.1",
    "babel-polyfill": "^6.0.0",
    "babel-preset-es2015": "^6.0.0",
    "babel-preset-react": "^6.0.0",
    "babel-preset-stage-0": "^6.0.0",
    "clean-webpack-plugin": "^0.1.3",
    "graylog-web-manifests": "^2.0.0-SNAPSHOT-1",
    "graylog-web-plugin": "~0.0.21",
    "json-loader": "^0.5.4",
    "react": "^0.14.6",
    "react-bootstrap": "^0.28.2",
    "react-dom": "^0.14.6",
    "react-hot-loader": "^3.0.0-beta.3",
    "react-proxy-loader": "^0.3.4",
    "webpack": "^1.12.2"
  }
```

Usage
-----

To be continued.

Getting started
---------------

This project is using Maven 3 and requires Java 8 or higher.

* Clone this repository.
* Run `mvn package` to build a JAR file.
* Optional: Run `mvn jdeb:jdeb` and `mvn rpm:rpm` to create a DEB and RPM package respectively.
* Copy generated JAR file in target directory to your Graylog plugin directory.
* Restart the Graylog.

Plugin Release
--------------

We are using the maven release plugin:

```
$ mvn release:prepare
[...]
$ mvn release:perform
```

This sets the version numbers, creates a tag and pushes to GitHub. Travis CI will build the release artifacts and upload to GitHub automatically.