#include <cstdio>
#include <cstring>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int
main ()
{
  string a, b;
  int s1[26];
  int s2[26];
  string res;
  while (getline (cin, a) && getline (cin, b))
    {
      int l1 = a.size (), l2 = b.size ();
      res = "";

      memset (s1, 0, sizeof (s1));
      memset (s2, 0, sizeof (s2));

      if (l1 > l2)
	{
	  for (int i = 0; i < l1; ++i)
	    {
	      s1[a[i] - 'a']++;
	      if (i < l2)
		{
		  s2[b[i] - 'a']++;
		}
	    }
	}
      else
	{
	  for (int i = 0; i < l2; ++i)
	    {
	      s2[b[i] - 'a']++;
	      if (i < l1)
		{
		  s1[a[i] - 'a']++;
		}
	    }
	}

      for (int i = 0; i < 26; ++i)
	for (int j = 0; j < min(s1[i], s2[i]);j++)
	  res = res + char('a' + i);

      cout << res << endl;
    }

  return 0;
}
