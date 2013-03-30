package org.pitest.mutationtest;

import java.util.Collection;

import org.pitest.Description;
import org.pitest.extension.ResultCollector;
import org.pitest.extension.TestUnit;
import org.pitest.functional.F2;
import org.pitest.functional.FCollection;
import org.pitest.testunit.AbstractTestUnit;

class MixedAnalysisUnit extends AbstractTestUnit implements
    MutationAnalysisUnit {

  private final Collection<MutationAnalysisUnit> children;

  public MixedAnalysisUnit(final Collection<MutationAnalysisUnit> children) {
    super(new Description("MixedAnalysisUnit"));
    this.children = children;
  }

  public int priority() {
    return FCollection.fold(sum(), 0, this.children);
  }

  private F2<Integer, MutationAnalysisUnit, Integer> sum() {
    return new F2<Integer, MutationAnalysisUnit, Integer>() {
      public Integer apply(final Integer a, final MutationAnalysisUnit b) {
        return a + b.priority();
      }

    };
  }

  @Override
  public void execute(final ClassLoader loader, final ResultCollector rc) {
    for (final TestUnit each : this.children) {
      each.execute(loader, rc);
      if (rc.shouldExit()) {
        break;
      }
    }
  }

}
