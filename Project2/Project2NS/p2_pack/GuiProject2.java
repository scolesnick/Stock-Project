package p2_pack;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ScrolledComposite;

import javax.swing.ButtonGroup;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

public class GuiProject2 {
	private final ButtonGroup buttonGroup = new ButtonGroup();

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GuiProject2 window = new GuiProject2();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		Data dat = new Data("./dow_jones_index.data");
		BasicPredictor stockMan = new Broker(dat);
		stockMan.setPortfolioAmount(10000);
		stockMan.predict();
		System.out.println("type 1 final amount $"+stockMan.getPortfolioAmount());
		
		System.out.println("--------------------------------\n--------------------------------");
		Broker1 stockerMan = new Broker1(dat);
		stockerMan.setPortfolioAmount(10000);
		stockerMan.predict();
		System.out.println("type 2 final amount $"+stockerMan.getPortfolioAmount());
		
		System.out.println("--------------------------------\n--------------------------------");
		Broker2 stockestMan = new Broker2(dat);
		stockestMan.setPortfolioAmount(10000);
		stockestMan.predict();
		System.out.println("type 3 final amount $"+stockestMan.getPortfolioAmount());
		
		System.out.println(dat.getStockCount());
		System.out.println(dat.getWeekCount());
		System.out.println(dat.getStocksWeek(1, 1));
		System.out.println(dat.getStockSymbol(2));
		System.out.println(dat.getStockName(2));
		System.out.println(dat.getWeekDate(3));		
		System.out.println(stockMan.rankStocks(3));
		
		shell = new Shell();
		shell.setSize(741, 550);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(10, 115, 202, 346);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
			
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		
		
		Slider slider = new Slider(composite, SWT.NONE);
		slider.setBounds(0, 357, 170, 17);
		slider.setVisible(false);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(121, 10, 91, 23);
		
		ComboViewer comboViewer = new ComboViewer(shell, SWT.NONE);
		Combo combo_1 = comboViewer.getCombo();
		combo_1.setBounds(121, 39, 91, 23);
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(239, 243, 431, 218);
		
		ScrollBar toScroll;

		
//		Button btnRadioButton = new Button(composite, SWT.RADIO);
//		btnRadioButton.setBounds(0, 20, 90, 16);
//		btnRadioButton.setText("Button2");
		
		for (int i = 0; i < dat.getStockCount(); i++) {
			Button btnAbutton = new Button(composite, SWT.RADIO);
			btnAbutton.setBounds(0, 0+i*18, 120, 16);
			btnAbutton.setText(dat.getStockName(i));
		}
		
//		for (int i = 0; i < dat.getStockCount(); i++) {
//			Button btnAbutton = new Button(composite, SWT.RADIO);
//			btnAbutton.setText(dat.getStockName(i));
//		//	btnAbutton
//		//	buttonGroup.add(btnAbutton);
//		}

	}
}