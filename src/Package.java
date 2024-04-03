//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class Package{ //уникальное имя пакета
//    private final String name;
//    //список пакетов, от которых зависит данный
//    private final List<Package> dependencies = new ArrayList<>();
//    public Package(String name) {
//        this.name = name;
//    }
//    public List<Package> getDependencies() {
//        return dependencies;
//    }
//    public String getName(){ return name;
//    }
//
//    // ПЕРЕОПРЕДЕЛЕН equals/hashcode
//}
//
//public class Project {
//    //имя проекта
//    private final String name;
//    //список пакетов проекта
//    private final List<Package> packages = new ArrayList<>();
//    public Project(String name){
//        this.name = name;
//    }
//    // ПЕРЕОПРЕДЕЛЕН equals/hashcode
//
//    /**
//     * Проверяет наличие циклических зависимостей между пакетами проекта.
//     Когда мы говорим "A зависит от B (или A -> B)", имеется в виду, что пакет B
//     содержится списке зависимостей (dependencies) пакета A.
//     * Например, есть проект1, в нем задан список пакетов - packages = [A]
//     * при зависимостях A->B->C->A – цикл есть
//     * при зависимостях A->B->D, A->C->D – цикла нет *
//     * Обращаем ваше внимание, что в packages у проекта не обязательно находятся все
//     * пакеты. В данном примере там находится только один пакет A. */
//    public Boolean hasCyclicDependencies(Project project, Package pack) throws IllegalAccessException {
//        Field[] fieldsProj = project.getClass().getDeclaredFields();
//        Field[] fieldsPack = pack.getClass().getDeclaredFields();
//        for(Field fieldProj : fieldsProj) {
//            for (Field fieldPack: fieldsPack) {
//                if (fieldProj.equals(fieldPack)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     * Упорядоченный список пакетов проекта для компиляции с учетом их
//     * зависимостей. Скомпилировать пакет мы можем только после успешной
//     компиляции его зависимостей.
//     * Например, для проекта A->B->C, D->C
//     порядок компиляции может быть C, B, A, D или C, D, B, A или C, B, D, A * Если скомпилировать не получается, то нужно выдавать ошибку.
//     *
//     * Обращаем ваше внимание, что в packages у проекта не обязательно находятся все * пакеты. В данном примере там находится только один пакет A.
//     */
////    public List<Package> getCompilationOrder(){
////
////
////    }
//}