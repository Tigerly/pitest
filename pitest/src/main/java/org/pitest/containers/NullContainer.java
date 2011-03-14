/*
 * Copyright 2010 Henry Coles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License. 
 */
package org.pitest.containers;

import java.util.Collections;
import java.util.List;

import org.pitest.TestResult;
import org.pitest.extension.Container;
import org.pitest.extension.ResultSource;
import org.pitest.extension.TestUnit;

public class NullContainer implements Container {

  public boolean awaitCompletion() {
    return true;
  }

  public ResultSource getResultSource() {
    return new ResultSource() {

      public List<TestResult> getAvailableResults() {
        return Collections.emptyList();
      }

      public boolean resultsAvailable() {
        return false;
      }

    };
  }

  public void setMaxThreads(final int maxThreads) {

  }

  public void shutdownWhenProcessingComplete() {

  }

  public void submit(final TestUnit c) {

  }

}