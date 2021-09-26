package tools.search;


interface StrategyList{
    Search getStrategy();
}

class ImplicitStrategy implements StrategyList{
    @Override
    public Search getStrategy() {
        return new ImplicitWait();
    }
}


class ExplicitStrategyVisible implements  StrategyList{
    @Override
    public Search getStrategy() {
       return new ExplicitWait();
    }
}


    enum Strategies{
    DEFAULT_STRATEGY(new ImplicitStrategy()),
    IMPLICIT_STRATEGY(new ImplicitStrategy()),
    EXPLICIT_STRATEGY(new ExplicitStrategyVisible());
    StrategyList search;

    Strategies(StrategyList search){this.search = search;}

    public Search getStrategy() {
        return search.getStrategy();
    }
}

 public  class SearchStrategy{
     private static Search search;


     public static Search setImplicitStrategy(){
         return  Strategies.IMPLICIT_STRATEGY.getStrategy();
     }

     public static Search setExplicitStrategy(){return Strategies.EXPLICIT_STRATEGY.getStrategy();}

     public static Search getSearch(){
         if (search == null){
             return Strategies.DEFAULT_STRATEGY.getStrategy();
         }
         return search;
     }

     public static Search  setSearch(Strategies strategy){

        search = strategy.getStrategy();
        return getSearch();

     }

 }