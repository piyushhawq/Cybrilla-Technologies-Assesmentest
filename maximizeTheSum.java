import java.util.*;
import java.io.*;
class Main {

    static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

public Reader()
{
    din = new DataInputStream(System.in);
    buffer = new byte[BUFFER_SIZE];
    bufferPointer = bytesRead = 0;
}

public Reader(String file_name) throws IOException
 {
    din = new DataInputStream(
    new FileInputStream(file_name));
    buffer = new byte[BUFFER_SIZE];
    bufferPointer = bytesRead = 0;
}


public String readLine() throws IOException

{
    byte[] buf = new byte[64]; 
    int cnt = 0, c;
    while ((c = read()) != -1) 
    {
    if (c == '\n') {
    if (cnt != 0) {
    break;
}
else
 {
    continue;

}
}
    buf[cnt++] = (byte)c;

    }

        return new String(buf, 0, cnt);
}


public int nextInt() throws IOException

{

    int ret = 0;
    byte c = read();

    while (c <= ' ')   
    {
        c = read();
    }
    boolean neg = (c == '-');
    if (neg)

    c = read();

do {

ret = ret * 10 + c - '0';

}
 while ((c = read()) >= '0' && c <= '9');

if (neg)

return -ret;

return ret;

}


public long nextLong() throws IOException

{

long ret = 0;

byte c = read();

while (c <= ' ')

c = read();

boolean neg = (c == '-');

if (neg)

c = read();

do {

ret = ret * 10 + c - '0';

} while ((c = read()) >= '0' && c <= '9');

if (neg)

return -ret;

return ret;
}

public double nextDouble() throws IOException

{

double ret = 0, div = 1;

byte c = read();


 

while (c <= ' ')


c = read();

boolean neg = (c == '-');
if (neg)

c = read();

do {

ret = ret * 10 + c - '0';

} while ((c = read()) >= '0' && c <= '9');


if (c == '.') {

while ((c = read()) >= '0' && c <= '9') {

ret += (c - '0') / (div *= 10);
}
 

}


if (neg)


return -ret;


return ret;

}


private void fillBuffer() throws IOException


{

bytesRead = din.read(buffer, bufferPointer = 0,BUFFER_SIZE);
if (bytesRead == -1)

buffer[0] = -1;


}


private byte read() throws IOException

{


if (bufferPointer == bytesRead)


fillBuffer();


return buffer[bufferPointer++];

}

public void close() throws IOException

{

if (din == null)

return;

din.close();

}

}

public static void main(String[] args) throws IOException {

Reader br = new Reader();

long t = br.nextLong();

for (long i =0;i<t;i++){

long a=br.nextLong(),b=br.nextLong(),c=0;

long[] s = new long[(int) a];


for(long j=0;j<a;j++)

{

s[(int) j]=br.nextLong();

}

HashMap<Long,Integer> hash = new HashMap<Long,Integer>();
for(int k=0;k<s.length;k++){

if (hash.containsKey(s[k])) {

hash.put(s[k], hash.get(s[k]) + 1);

} else {

hash.put(s[k],1);

}
}

ArrayList<Long> arr = new ArrayList<Long>();

for (Map.Entry<Long, Integer> e : hash.entrySet()) {
arr.add(e.getKey()*e.getValue());
}
Collections.sort(arr);
Collections.reverse(arr);
for(long m:arr){
if(b>0 && m>=0){
c+=m;
b-=1;
}
}
System.out.println(c);
hash.clear();
arr.clear();
c=0;

}
}
}
