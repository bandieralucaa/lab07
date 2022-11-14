package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawResult;
import static java.lang.System.out;

public class DrawNumberStandardOutputView implements DrawNumberView {

    public void setController(final DrawNumberController controller) {
        // do nothing
    }

    public void start(){
        // do nothing
    }
    
    public void result(final DrawResult result) {
        out.println(result.getDescription());
    }
}
