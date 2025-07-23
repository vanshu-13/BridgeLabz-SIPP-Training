package runtimeAnalysis;

public class StringConcatenationPerformance {

    public static void main(String[] args) {
        int[] operationCounts = {1000, 10000, 1000000};

        for (int N : operationCounts) {
            System.out.println("Operations Count: " + N);

            String[] strings = new String[N];
            for (int i = 0; i < N; i++) {
                strings[i] = "a";
            }

            long startString = System.nanoTime();
            String resultString = "";
            for (int i = 0; i < N; i++) {
                resultString += strings[i];
            }
            long endString = System.nanoTime();
            double timeStringMs = (endString - startString) / 1_000_000.0;
            System.out.printf("String (immutable): %.2f ms%n", timeStringMs);

            long startBuilder = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(strings[i]);
            }
            String resultBuilder = sb.toString();
            long endBuilder = System.nanoTime();
            double timeBuilderMs = (endBuilder - startBuilder) / 1_000_000.0;
            System.out.printf("StringBuilder: %.2f ms%n", timeBuilderMs);

            long startBuffer = System.nanoTime();
            StringBuffer sbuff = new StringBuffer();
            for (int i = 0; i < N; i++) {
                sbuff.append(strings[i]);
            }
            String resultBuffer = sbuff.toString();
            long endBuffer = System.nanoTime();
            double timeBufferMs = (endBuffer - startBuffer) / 1_000_000.0;
            System.out.printf("StringBuffer: %.2f ms%n", timeBufferMs);

            System.out.println("---------------------------------------------------");
        }
    }
}