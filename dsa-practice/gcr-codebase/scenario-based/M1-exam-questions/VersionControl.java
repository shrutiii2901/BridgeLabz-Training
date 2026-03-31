import java.util.*;

class FileVersion{
    String version;
    int size;

    FileVersion(String v,int s){
        version=v;
        size=s;
    }
}

public class VersionControl{

    static Map<String,List<FileVersion>> map=new HashMap<>();
    static Map<String,String> latest=new HashMap<>();

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        while(n-- >0){

            String line=sc.nextLine();
            String[] p=line.split(" ");

            switch(p[0]){

                case "UPLOAD":
                    String name=p[1];
                    String ver=p[2];
                    int size=Integer.parseInt(p[3]);

                    map.putIfAbsent(name,new ArrayList<>());

                    boolean exists=false;
                    for(FileVersion f:map.get(name))
                        if(f.version.equals(ver)) exists=true;

                    if(!exists){
                        map.get(name).add(new FileVersion(ver,size));
                        latest.put(name,ver);
                    }
                    break;

                case "FETCH":
                    name=p[1];
                    if(!map.containsKey(name)){
                        System.out.println("File Not Found");
                        break;
                    }

                    List<FileVersion> list=map.get(name);

                    list.sort((a,b)->{
                        if(a.size==b.size)
                            return a.version.compareTo(b.version);
                        return a.size-b.size;
                    });

                    for(FileVersion f:list)
                        System.out.println(name+" "+f.version+" "+f.size);

                    break;

                case "LATEST":
                    name=p[1];
                    if(!map.containsKey(name)){
                        System.out.println("File Not Found");
                        break;
                    }

                    String v=latest.get(name);

                    for(FileVersion f:map.get(name))
                        if(f.version.equals(v))
                            System.out.println(name+" "+f.version+" "+f.size);
                    break;

                case "TOTAL_STORAGE":
                    name=p[1];
                    if(!map.containsKey(name)){
                        System.out.println("File Not Found");
                        break;
                    }

                    int sum=0;
                    for(FileVersion f:map.get(name))
                        sum+=f.size;

                    System.out.println(name+" "+sum);
            }
        }
    }
}