import React from 'react';
import { Row, Col, Button } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';

import { DocumentTitle, PageHeader } from 'components/common';
import CreateIndicatorListButton from 'threatmanager/CreateIndicatorListButton';
import IndicatorSummaryComponent from 'threatmanager/IndicatorSummaryComponent';

import Routes from 'routing/Routes';
import DocsHelper from 'util/DocsHelper';

const ThreatManagerOverviewPage = React.createClass({
  render() {
    return (
      <DocumentTitle title="Threat Manager">
        <div>
          <PageHeader title="Threat Manager Main">
            <span>
              Manage and Track Threat Indicators.
            </span>

            <Row className="content">
              <Col md={12}>
                <CreateIndicatorListButton currentUser={this.state.currentUser} onStreamSave={this._onSave}
                                 indexSets={this.state.indexSets} />
              </Col>
            </Row>
          </PageHeader>

          <Row className="content">
            <Col md={12}>
              <IndicatorSummaryComponent currentUser={this.state.currentUser} onStreamSave={this._onSave}
                               indexSets={this.state.indexSets} />
            </Col>
          </Row>
        </div>
      </DocumentTitle>
    );
  },
});

export default ThreatManagerOverviewPage;
