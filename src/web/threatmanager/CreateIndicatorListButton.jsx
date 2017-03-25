import React from 'react';
import { Button } from 'react-bootstrap';
import IndicatorListForm from 'threatmanager/IndicatorListForm';

const CreateIndicatorListButton = React.createClass({
    propTypes: {
        buttonText: React.PropTypes.string,
        bsStyle: React.PropTypes.string,
        bsSize: React.PropTypes.string,
        className: React.PropTypes.string,
        onSave: React.PropTypes.func.isRequired,
    },
    getDefaultProps() {
        return {
            buttonText: 'Create Threat Indicator List',
        };
    },
    onClick() {
        this.refs.indicatorListForm.open();
    },
    render() {
        return (
            <span>
        <Button bsSize={this.props.bsSize} bsStyle={this.props.bsStyle} className={this.props.className}
                onClick={this.onClick}>
          {this.props.buttonText}
        </Button>
        <IndicatorListForm ref="indicatorListForm" title="Creating Stream" onSubmit={this.props.onSave} />
      </span>
        );
    },
});

export default CreateIndicatorListButton;