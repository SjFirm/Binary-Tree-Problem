using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BinaryTreeTest
{
    class Program
    {
        private static int _lastInt = 0;
        static void Main(string[] args)
        {

            var jagged = new int[15][]
            {
                new []{215},
                new []{192, 124},
                new []{117, 269, 442},
                new []{218, 836, 347, 235},
                new []{320, 805, 522, 417, 345},
                new []{229, 601, 728, 835, 133, 124},
                new []{248, 202, 277, 433, 207, 263, 257},
                new []{359, 464, 504, 528, 516, 716, 871, 182},
                new []{461, 441, 426, 656, 863, 560, 380, 171, 923},
                new []{381, 348, 573, 533, 448, 632, 387, 176, 975, 449},
                new []{223, 711, 445, 645, 245, 543, 931, 532, 937, 541, 444},
                new []{330, 131, 333, 928, 376, 733, 017, 778, 839, 168, 197, 197},
                new []{131, 171, 522, 137, 217, 224, 291, 413, 528, 520, 227, 229, 928},
                new []{223, 626, 034, 683, 839, 052, 627, 310, 713, 999, 629, 817, 410, 121},
                new []{924, 622, 911, 233, 325, 139, 721, 218, 253, 223, 107, 233, 230, 124, 233},

            };
            var result = 0;
            _lastInt = jagged[0][0];
            var list = new List<int>();
            int nextNodeA = 0, nextNodeB = 0;
            foreach (var t in jagged)
            {
                for (var j = 0; j < t.Length; j++)
                {
                    if (t.Length == 1)
                    {
                        _lastInt = t[j];
                        list.Add(_lastInt);
                        result += _lastInt;

                        nextNodeA = j;
                        nextNodeB = j + 1;
                        break;
                    }
                    else
                    {
                        string node;
                        _lastInt = Compare(t[nextNodeA], t[nextNodeB], out node);
                        list.Add(_lastInt);
                        result += _lastInt;
                        if (node == "a")
                        {
                            nextNodeB = nextNodeA + 1;
                            break;
                        }
                        else
                        {
                            nextNodeA = nextNodeB;
                            nextNodeB = nextNodeB + 1;
                            break;
                        }

                    }
                }
            }
            Console.WriteLine("Max sum: " + result);

            int last = list.Last();
            Console.Write("Path:  ");
            var str = "";
            foreach (var i in list)
            {
                if (i.Equals(last))
                    str += i;
                else
                    str += i + ", ";
            }
            Console.Write(str);
            Console.ReadLine();
        }

        private static int Compare(int a, int b, out string ab)
        {
            var arr = new int[2];
            if (_lastInt % 2 == 0)
            {
                if (!IsEven(a))
                    arr[0] = a;
                if (!IsEven(b))
                    arr[1] = b;
                var result = arr.Max();
                ab = result == a ? "a" : "b";
                return result;
            }
            else
            {
                if (IsEven(a))
                    arr[0] = a;
                if (IsEven(b))
                    arr[1] = b;
                var result = arr.Max();
                ab = result == a ? "a" : "b";
                return result;
            }
        }


        private static bool IsEven(int a)
        {
            return a % 2 == 0;
        }
    }
}
