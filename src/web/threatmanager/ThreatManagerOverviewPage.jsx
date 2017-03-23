import React from 'react';
import { Row, Col, Button } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';

import { DocumentTitle, PageHeader } from 'components/common';
import DocumentationLink from 'components/support/DocumentationLink';

import Routes from 'routing/Routes';
import DocsHelper from 'util/DocsHelper';

const ThreatManagerOverviewPage = React.createClass({
  render() {
    return (
      <DocumentTitle title="Threat Manager">
        <div>
          <PageHeader title="Threat Manager Main">
            <span>
              The Threat Manager lets you manage, work with, and track threat indicators.
            </span>

            <span>
              <LinkContainer to={Routes.pluginRoute('SYSTEM_PIPELINES_SIMULATE')}>
                <Button bsStyle="info">Simulate processing</Button>
              </LinkContainer>
              &nbsp;
              <LinkContainer to={Routes.pluginRoute('SYSTEM_PIPELINES_RULES')}>
                <Button bsStyle="info">Manage rules</Button>
              </LinkContainer>
            </span>
          </PageHeader>

      </DocumentTitle>
    );
  },
});

export default ThreatManagerOverviewPage;
