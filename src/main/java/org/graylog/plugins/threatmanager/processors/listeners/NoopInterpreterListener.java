/**
 * This file is part of Graylog Pipeline Processor.
 *
 * Graylog Pipeline Processor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog Pipeline Processor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog Pipeline Processor.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog.plugins.threatmanager.processors.listeners;

import org.graylog.plugins.threatmanager.ast.ThreatList;
import org.graylog.plugins.threatmanager.ast.Indicator;
import org.graylog.plugins.threatmanager.ast.Stage;
import org.graylog2.plugin.Message;

import java.util.Set;

public class NoopInterpreterListener implements InterpreterListener {
    @Override
    public void startProcessing() {

    }

    @Override
    public void finishProcessing() {

    }

    @Override
    public void processStreams(Message messageId, Set<ThreatList> pipelines, Set<String> streams) {

    }

    @Override
    public void enterStage(Stage stage) {

    }

    @Override
    public void exitStage(Stage stage) {

    }

    @Override
    public void evaluateRule(Indicator rule, ThreatList pipeline) {

    }

    @Override
    public void failEvaluateRule(Indicator rule, ThreatList pipeline) {

    }

    @Override
    public void satisfyRule(Indicator rule, ThreatList pipeline) {

    }

    @Override
    public void dissatisfyRule(Indicator rule, ThreatList pipeline) {

    }

    @Override
    public void executeRule(Indicator rule, ThreatList pipeline) {

    }

    @Override
    public void failExecuteRule(Indicator rule, ThreatList pipeline) {

    }

    @Override
    public void continuePipelineExecution(ThreatList pipeline, Stage stage) {

    }

    @Override
    public void stopPipelineExecution(ThreatList pipeline, Stage stage) {

    }
}
