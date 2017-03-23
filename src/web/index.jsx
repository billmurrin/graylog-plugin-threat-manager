// eslint-disable-next-line no-unused-vars
import webpackEntry from 'webpack-entry';

import packageJson from '../../package.json';
import { PluginManifest, PluginStore } from 'graylog-web-plugin/plugin';
import ThreatManagerOverviewPage from 'threatmanager/ThreatManagerOverviewPage';
//import PipelineDetailsPage from 'pipelines/PipelineDetailsPage';
//import SimulatorPage from 'simulator/SimulatorPage';
//import RulesPage from 'rules/RulesPage';
//import RuleDetailsPage from 'rules/RuleDetailsPage';

PluginStore.register(new PluginManifest(packageJson, {
  routes: [
    { path: '/threatmanager', component: ThreatManagerOverviewPage },
  ],

  navigation: [
    { path: '/threatmanager', description: 'Threat Manager' },
    //{ path: '/threatmanager', description: 'Threat Manager', permissions: 'inputs:create' },
  ],
}));
