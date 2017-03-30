/**
 * This file is part of Graylog Threat Manager.
 *
 * Graylog Threat Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog Threat Manager is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog Threat Manager.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog.plugins.threatmanager.simulator;

import org.graylog.plugins.threatmanager.ast.ThreatList;
import org.graylog.plugins.threatmanager.ast.Indicator;
import org.graylog.plugins.threatmanager.ast.Stage;
import org.graylog.plugins.threatmanager.processors.listeners.InterpreterListener;
import org.graylog2.plugin.Message;

import java.util.Set;

class SimulatorInterpreterListener implements InterpreterListener {
    private final PipelineInterpreterTracer executionTrace;

    SimulatorInterpreterListener(PipelineInterpreterTracer executionTrace) {
        this.executionTrace = executionTrace;
    }

    @Override
    public void startProcessing() {
        executionTrace.startProcessing("Starting message processing");
    }

    @Override
    public void finishProcessing() {
        executionTrace.finishProcessing("Finished message processing");
    }

    @Override
    public void processStreams(Message message, Set<ThreatList> pipelines, Set<String> streams) {
        executionTrace.addTrace("Message " + message.getId() + " running " + pipelines + " for streams " + streams);
    }

    @Override
    public void enterStage(Stage stage) {
        executionTrace.addTrace("Enter " + stage);
    }

    @Override
    public void exitStage(Stage stage) {
        executionTrace.addTrace("Exit " + stage);
    }

    @Override
    public void evaluateRule(Indicator rule, ThreatList pipeline) {
        executionTrace.addTrace("Evaluate " + rule + " in " + pipeline);
    }

    @Override
    public void failEvaluateRule(Indicator rule, ThreatList pipeline) {
        executionTrace.addTrace("Failed evaluation " + rule + " in " + pipeline);
    }

    @Override
    public void satisfyRule(Indicator rule, ThreatList pipeline) {
        executionTrace.addTrace("Evaluation satisfied " + rule + " in " + pipeline);
    }

    @Override
    public void dissatisfyRule(Indicator rule, ThreatList pipeline) {
        executionTrace.addTrace("Evaluation not satisfied " + rule + " in " + pipeline);
    }

    @Override
    public void executeRule(Indicator rule, ThreatList pipeline) {
        executionTrace.addTrace("Execute " + rule + " in " + pipeline);
    }

    @Override
    public void failExecuteRule(Indicator rule, ThreatList pipeline) {
        executionTrace.addTrace("Failed execution " + rule + " in " + pipeline);
    }

    @Override
    public void continuePipelineExecution(ThreatList pipeline, Stage stage) {
        executionTrace.addTrace("Completed " + stage + " for " + pipeline + ", continuing to next stage");
    }

    @Override
    public void stopPipelineExecution(ThreatList pipeline, Stage stage) {
        executionTrace.addTrace("Completed " + stage + " for " + pipeline + ", NOT continuing to next stage");
    }
}
