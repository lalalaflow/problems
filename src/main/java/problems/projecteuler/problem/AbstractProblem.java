package problems.projecteuler.problem;

import problems.projecteuler.problem.Problem;
import problems.projecteuler.util.ProjectEulerMath;

public abstract class AbstractProblem implements Problem {
    protected int iLimitNumber;
    protected long lLimitNumber;
    private ProjectEulerMath projectEulerMath;

    public AbstractProblem() {
        this.setProjectEulerMath();
    }

    public AbstractProblem(int limitNumber) {
        this.iLimitNumber = limitNumber;
        this.setProjectEulerMath();
    }

    public AbstractProblem(long lLimitNumber) {
        this.lLimitNumber = lLimitNumber;
        this.setProjectEulerMath();
    }

    private void setProjectEulerMath() {
        this.projectEulerMath = new ProjectEulerMath();
    }

    protected ProjectEulerMath getProjectEulerMath() {
        return this.projectEulerMath;
    }
}
