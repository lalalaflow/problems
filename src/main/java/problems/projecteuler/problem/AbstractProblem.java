package problems.projecteuler.problem;

public abstract class AbstractProblem implements Problem {
    protected int iLimitNumber;
    protected long lLimitNumber;

    public AbstractProblem() {}

    public AbstractProblem(int limitNumber) {
        this.iLimitNumber = limitNumber;
    }

    public AbstractProblem(long lLimitNumber) {
        this.lLimitNumber = lLimitNumber;
    }

    abstract public void solve();
}
