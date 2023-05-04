package View;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author TUNGDUONG
 */
public class PieChartMain {

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Cây lương thực", new Double(8320.3));
        dataset.setValue("Cây công nghiệp", new Double(2337.3));
        dataset.setValue("Cây thực phẩm, cây ăn quả, cây khác", new Double(2173.8));
        dataset.setValue("xxxxx", 1000);
        return dataset;
    }

    private static JFreeChart createPieChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Biểu đồ về sự thay đổi cơ cấu diện tích gieo trồng".toUpperCase(),
                dataset, true, true, true);
        return chart;
    }

    public static void main(String[] args) {
        JFreeChart pieChart = createPieChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(pieChart);
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

}